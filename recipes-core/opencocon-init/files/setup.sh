#!/bin/bash

DEFCONF="/usr/share/cocon/default.cnf"
SECCONF="/media/cf/media/realroot/cocon.cnf"
SECCONF_EXTREME="/cocon.cnf"
CNFFILE="/tmp/.cocon.cnf"
ALLOW_CNF_BOOL="COCON_FORCEFB\|COCON_FORCESVGA\|COCON_WAIT_CONNECTED\|COCON_POWEROFF_AFTER_AUTOCONNECT"
ALLOW_CNF_STR="COCON_KBD_CONSOLE\|COCON_KBD_X_MODEL\|COCON_KBD_X_LAYOUT\|COCON_KBD_X_VARIANT\|COCON_AUTOCONNECT\|COCON_RDP_HOST\|COCON_RDP_USER\|COCON_RDP_DOMAIN\|COCON_RDP_KBD"
ALLOW_CNF_FILE="COCON_RDP_RDPFILE\|COCON_XCONF_ADD"

read_args() {
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            debug) set -x
                COCON_DEBUG=1
                export COCON_DEBUG
                echo "COCON_DEBUG=1"  >> $CNFFILE
                ;;
            forcefb1|forcefb2|forcefb3|forcefb)
                echo "COCON_FORCEFB=1"  >> $CNFFILE
                ;;
            forcesvga)
                echo "COCON_FORCESVGA=1" >> $CNFFILE
                ;;
            shell) sh ;;
        esac
    done
}

get_partition_type()
{
    fstype=`blkid /dev/$dev`
    fstype=`expr "$fstype" : '.*TYPE="\([A-Za-z0-9]*\)".*'`
}

# Read cocon.cnf
read_cocon_cnf() {
  while read line
  do
    line=`echo $line | dos2unix`
    line=`echo $line | sed -e '/^#/d'`
    optarg=`echo $line | cut -d "=" -f 2`
    arg=`echo "$line" | cut -d "=" -f 1`

    if [ "$arg" ];
    then
      echo "$arg=$optarg"
    fi

    if expr "$arg" : $ALLOW_CNF_BOOL > /dev/null ;
    then
      # Data is boolean
      echo "$arg=$((optarg > 0 ? 1: 0))" >> $CNFFILE
    fi

    if expr "$arg" : $ALLOW_CNF_STR > /dev/null ;
    then
      # Data is string (TODO: Sanitry Check)
      echo "$arg=$optarg" >> $CNFFILE
    fi

    if expr "$arg" : $ALLOW_CNF_FILE > /dev/null ;
    then
      # One filename : convert to fullpath on opencocon
      cnf_file=`dirname $1`
      argtmp="$cnf_file/$optarg"
      echo "$argtmp"
#      /bin/sh 
      if [ ! -r "$line" ];
      then
        echo "Error: $cnf_file/$optarg on $arg is not readable."
        #unset $arg
      else 
      
        # Copy to /tmp
        mkdir -p /tmp/.cocon.cnf.files/
        cp $argtmp /tmp/.cocon.cnf.files/
      
        echo "$arg=/tmp/.cocon.cnf.files/`basename $argtmp`" >> $CNFFILE

#        /bin/sh
      fi
    fi

  done < $1
}

scan_cocon_setting()
{
  # Scan all available device/partitions
  cat /proc/diskstats | sort -r > /var/volatile/tmp/.cocon.diskstats

  if [ "$ROOT_DEVICE" ];
  then
    # Exclude Boot device (because already loaded)
    sed '/$ROOT_DEVICE/d' /var/volatile/tmp/.cocon.diskstats
  fi

  while read maj min dev ex1 ex2 ex3 ex4 ex5 ex6 ex7 ex8 ex9 ex10 ex11; do
    if [ -z "$maj" -o "$maj" = "major" ]; then
        continue;
    fi

    get_partition_type
    if [ "$fstype" = "iso9660" -o "$fstype" = "vfat" -o "$fstype" = "ext3" -o "$fstype" = "ntfs" ];
    then
        echo "Scanning setting from : $dev"
        mkdir /mnt/cfg
        mount -o ro $dev /mnt/cfg
        if [ -r /mnt/cfg/cocon.cnf ];
        then
          echo  " --> cocon.cnf found"
          read_cocon_cnf /mnt/cfg/cocon.cnf
        fi
        umount $dev
        true
    fi
  done < /var/volatile/tmp/.cocon.diskstats
}


read_args

/sbin/modprobe zram


# Alloc /dev
mount -t devtmpfs devtmpfs /dev

# mount missing /dev/pts
if [ ! -d /dev/pts ];
then
  mkdir /dev/pts
fi
mount -t devpts -o mode=0620,gid=5 none /dev/pts

# mdev before udev
#mdev -s

# mount missing volatile
mount -t tmpfs none /var/volatile
mkdir /var/volatile/tmp
mkdir /var/volatile/log
mkdir /var/volatile/run
mkdir /var/volatile/lock

# Run udev daemon
/etc/init.d/udev restart

# zram
COCON_MEM_MB=`free -m | grep "Mem:" | sed -r "s/Mem://" | sed -r "s/^[[:space:]]*([0-9]+).*/\\1/"`
echo "Memory: $COCON_MEM_MB MB"

if [ "$COCON_MEM_MB" -lt 240 ];
then
  echo $(($COCON_MEM_MB*1048576)) > /sys/block/zram0/disksize
  sleep 2
  mkswap /dev/zram0
  swapon /dev/zram0
fi

# Read setting file.
# First : /usr/share/cocon/default.cnf
# Second : /mnt/cf/mnt/realroot/cocon.cnf
# Third : (mounted device except boot device)/cocon.cnf [TODO]
read_cocon_cnf "$DEFCONF"
if [ -z "$BOOT_FS" ];
then
  if [ -r $SECCONF_EXTREME ];
  then
    read_cocon_cnf $SECCONF_EXTREME
  fi
else
  if [ -r $SECCONF ];
  then
    read_cocon_cnf $SECCONF
  fi
fi

scan_cocon_setting

# After parsing setting file, read .cocon.cnf
if [ -e $CNFFILE ];
then
  . $CNFFILE
fi

# Enable Framebuffer console : needed for i810
if [ -c /dev/fb0 ];
then
  /sbin/modprobe fbcon
fi

# Daemon
mkdir -p /var/run/dbus/
/etc/init.d/dbus-1 start
/etc/init.d/connman start

# Keymap (TODO)
if [ -z $COCON_KBD_CONSOLE ];
then
  COCON_KBD_CONSOLE="jp106"
fi

/usr/bin/loadkeys $COCON_KBD_CONSOLE


if [ "$COCON_DEBUG" -eq 1 ];
then
  echo "Debug : after setup.sh"
  /bin/sh
fi
