#
# based on 30-bootmenu.sh (c) 2007 Paul Sokolovsky
#

# Cocon-crusoe for opencocon

E="\033["
MOUNTLOC="/media/realroot"
UNIONLOC="/media/union"
RAMLOC="/media/ram"
OLDLOC="/media/cf"

#if ! (echo " " | read -n1 foo) >/dev/null 2>&1; then
#    echo "'read' command lacks -n switch support, aborting" 
#    exit 1
#fi


# And, do udev
/etc/init.d/udev start


get_partition_type()
{
    fstype=`blkid /dev/$dev`
    fstype=`expr "$fstype" : '.*TYPE="\([A-Za-z0-9]*\)".*'`
}

boot_iso9660()
{
    ROOT_DEVICE="/dev/$1"
    export ROOT_DEVICE

    if [ -z "$SQSFILE" ];
    then
      SQSFILE="crusoe.sqs"
    fi

    echo "--- coconcrusoe boot seq. ---"
    echo "Boot from: $ROOT_DEVICE, $SQSFILE"
   
    mount -o ro $ROOT_DEVICE $MOUNTLOC 

    if ! [ -e $MOUNTLOC/$SQSFILE ]; then
      echo "... is not contain $SQSFILE, try next. "
      umount $MOUNTLOC
      return 1
    fi

    echo "mount squashfs"

    # TODO : optional root sqs file
    losetup /dev/loop0 $MOUNTLOC/$SQSFILE
    mount -t squashfs /dev/loop0 $UNIONLOC

    echo "union with aufs"
    mount -t tmpfs none $RAMLOC
#    mkdir -p /stage2/tmp/root-rw
    
    mount -t aufs -o br:$RAMLOC:$UNIONLOC none $UNIONLOC
#    mount -t aufs -o br:/stage2/tmp/etc-rw:/stage2/etc none /stage2/etc
#    mount -t aufs -o br:/stage2/tmp/var-rw:/stage2/var none /stage2/var
#    mount -t aufs -o br:/stage2/tmp/home-rw:/stage2/home none /stage2/home
#    mount -t aufs -o br:/stage2/tmp/usr-rw:/stage2/usr none /stage2/usr
#    mount -t aufs -o br:/stage2/tmp/lib-rw:/stage2/lib none /stage2/lib

    echo "--- switch root ---"
    /etc/init.d/udev stop
    umount -l /proc
    umount /sys
    umount -l /dev

#    cd /stage2
#    exec switch_root -c /dev/console . /sbin/init

    # Pivot to real opencocon
    # cd $UNIONLOC
    pivot_root $UNIONLOC $UNIONLOC/$OLDLOC
    exec chroot . /sbin/init <dev/console >dev/console 2>&1

}

scan_device()
{
  # Scan all available device/partitions
  while read maj min dev ex1 ex2 ex3 ex4 ex5 ex6 ex7 ex8 ex9 ex10 ex11; do
    if [ -z "$maj" -o "$maj" = "major" ]; then
        continue;
    fi

    get_partition_type
    if [ "$fstype" = "iso9660" ]; then
        # Comment following line to show all available block devices regardless of FS (for debug purposes)
        BOOT_FS="$fstype"
        export BOOT_FS
        boot_iso9660 $dev
        true
    fi
    if [ "$fstype" = "vfat" ]; then
        BOOT_FS="$fstype"
        export BOOT_FS
        boot_iso9660 $dev
        true
    fi
    if [ "$fstype" = "ext3" ]; then
      # ext3 : need some customize...
      BOOT_FS="$fstype"
      export BOOT_FS
      boot_iso9660 $dev
      true
    fi


  done < /proc/diskstats
}

i=1
while test $i -le 20 ;
do
  echo "--- scanning root cd (part $i)---"
  scan_device 
  sleep 5
  i=`expr $i + 1` 
done


echo " Fallback shell. "
exec /bin/sh
