#
# based on 30-bootmenu.sh (c) 2007 Paul Sokolovsky
#

# Cocon-crusoe for opencocon

E="\033["
MOUNTLOC="stage1"

#if ! (echo " " | read -n1 foo) >/dev/null 2>&1; then
#    echo "'read' command lacks -n switch support, aborting" 
#    exit 1
#fi

# first, read some modules
modprobe loop
modprobe aufs
modprobe squashfs

# And, do udev
/initrd.d/udev-cocon

mkdir -p $MOUNTLOC

get_partition_type()
{
    fstype=`blkid /dev/$dev`
    fstype=`expr "$fstype" : '.*TYPE="\([A-Za-z0-9]*\)".*'`
}

boot_iso9660()
{
    ROOT_DEVICE="/dev/$1"
   
    echo "--- coconcrusoe boot seq. ---"
    echo "Boot from: $ROOT_DEVICE"
   
    mount $ROOT_DEVICE /$MOUNTLOC 

#    if ! test -d /$MOUNTLOC/crusoe.sqs; then
#      echo "... is not contain crusoe.sqs, try next. "
#      umount /$MOUNTLOC
#      return 1
#    fi


   
    echo "mount squashfs"
    mkdir /stage2

    losetup /dev/loop0 /$MOUNTLOC/crusoe.sqs
    mount -t squashfs /dev/loop0 /stage2


    mount -t tmpfs none /stage2/tmp
    mkdir -p /stage2/tmp/root-rw
    
    echo "union with aufs"
    mount -t aufs -o br:/stage2/tmp/root-rw:/stage2 none /stage2
#    mount -t aufs -o br:/stage2/tmp/etc-rw:/stage2/etc none /stage2/etc
#    mount -t aufs -o br:/stage2/tmp/var-rw:/stage2/var none /stage2/var
#    mount -t aufs -o br:/stage2/tmp/home-rw:/stage2/home none /stage2/home
#    mount -t aufs -o br:/stage2/tmp/usr-rw:/stage2/usr none /stage2/usr
#    mount -t aufs -o br:/stage2/tmp/lib-rw:/stage2/lib none /stage2/lib


    echo "--- switch root ---"
    pkill udevd
    umount /proc
    umount /sys

    cd /stage2
    exec switch_root -c /dev/console . /sbin/init

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
