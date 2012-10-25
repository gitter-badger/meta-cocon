#!/bin/sh

MODULE_DIR=/initrd.d
BOOT_ROOT=
ROOT_DEVICE=

early_setup() {
    mount -t proc proc /proc
    mount -t sysfs sysfs /sys
}

dev_setup()
{
  # TODO : move here (call cocon-udev)
    echo -n "initramfs: Creating device nodes: "
}

read_args() {
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            root=*)
                ROOT_DEVICE=$optarg ;;
            rootfstype=*)
                ROOT_FSTYPE=$optarg ;;
            rootdelay=*)
                rootdelay=$optarg ;;
            debug) set -x ;;
            shell) sh ;;
        esac
    done
}

#do_depmod() {
  # maybe depmod not need in thisplace
#  mount -t tmpfs none /media/card
#  mount -t aufs -o br:/media/card:/lib/modules none /lib/modules
#	[ -e "/lib/modules/$(uname -r)/modules.dep" ] || depmod -a
#}

load_module() {
    # Cannot redir to $CONSOLE here easily - may not be set yet
    echo "initramfs: Loading $module module"
    source $1
}

load_modules() {
    for module in $MODULE_DIR/$1; do
        [ -e "$module"  ] && load_module $module
    done
}

#boot_root() {
#    cd $BOOT_ROOT
#    exec switch_root -c /dev/console $BOOT_ROOT /sbin/init
#}

fatal() {
    echo $1 >$CONSOLE
    echo >$CONSOLE
    exec sh
}


echo "Starting opencocon initrd boot..."
early_setup
load_modules '0*'
# do_depmod

[ -z "$CONSOLE" ] && CONSOLE="/dev/console"

read_args

if [ -z "$rootdelay" ]; then
    rootdelay="2"
fi
if [ -n "$rootdelay" ]; then
    echo "Waiting $rootdelay seconds for devices to settle..." >$CONSOLE
    sleep $rootdelay
fi

dev_setup

load_modules '[1-9]*'

# [ -n "$BOOT_ROOT" ] && boot_root

fatal "No valid root device was specified.  Please add root=/dev/something to the kernel command-line and try again."
