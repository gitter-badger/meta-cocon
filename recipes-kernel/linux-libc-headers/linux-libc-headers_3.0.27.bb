require recipes-kernel/linux-libc-headers/linux-libc-headers.inc
#LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

B = "${S}"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PROVIDES = "linux-libc-headers"
RPROVIDES_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dbg = "linux-libc-headers-dbg"
KBRANCH ?= "standard/base"
KMETA ?= "meta"
PV = "3.0.27"
PR = "r0"

SRC_URI += "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
        ftp://get.opencocon.org/opencocon/sources-supply/aufs-snapshot_${PV}.tar.gz;name=aufs \
	file://linux-3.0.27-headers_install-fix-__packed-in-exported-kernel-head.patch \
"


# force this to empty to prevent installation failures, we aren't
# building a device tree as part of kern headers
KERNEL_DEVICETREE = ""

set_arch() {
	case ${TARGET_ARCH} in
		arm*)     ARCH=arm ;;
		i*86*)    ARCH=i386 ;;
		ia64*)    ARCH=ia64 ;;
		mips*)    ARCH=mips ;;
		powerpc*) ARCH=powerpc ;;
		x86_64*)  ARCH=x86_64 ;;
	esac
}

do_configure() {
	set_arch
	oe_runmake allnoconfig ARCH=$ARCH
}

do_install() {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH

        # The ..install.cmd conflicts between various configure runs
        find ${D}${includedir} -name ..install.cmd | xargs rm -f
}

# The following tasks are not required when we just want
# headers. So we override and stub them out.
do_kernel_configme() {
}

#do_patch () {
#}

do_compile () {
}

do_validate_branches () {
}

do_kernel_configcheck () {
}

BBCLASSEXTEND = "nativesdk"

SRC_URI[kernel.md5sum] = "6e229c9a21c1b2ba0b84cb61e758275f"
SRC_URI[kernel.sha256sum] = "539623d75f35a29f722ee1aac2876385cbdb590d0566539d1eeebc1d6f6619ca"

SRC_URI[aufs.md5sum] = "fa57176f076e6dfb346aa44c8c1ae451"
SRC_URI[aufs.sha256sum] = "67e6ce2640f844470bb94aedd15e6e3b6890179a15bf68d0f1aa786b3b3f67ef"
