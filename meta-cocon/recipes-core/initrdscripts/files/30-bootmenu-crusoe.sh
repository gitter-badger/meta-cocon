#
# based on 30-bootmenu.sh (c) 2007 Paul Sokolovsky
#

# Cocon-crusoe for opencocon

E="\033["
MOUNTLOC="/mnt/realroot"
UNIONLOC="/mnt/union"
RAMLOC="/mnt/ram"
OLDLOC="/mnt/oldroot"
NEWLOC="/mnt/newroot"
COPYTORAMLOC="/mnt/copytoram"
ISOLOC="/mnt/iso"
MODLOC="/mnt/mod"
DISKSTATS_TMP="/var/volatile/tmp/.cocon.diskstats"

# Alloc /dev
mount -t devtmpfs devtmpfs /dev

# mount missing volatile
mount -t tmpfs none /var/volatile
mkdir /var/volatile/tmp
mkdir /var/volatile/log
mkdir /var/volatile/run
mkdir /var/volatile/run/dbus
mkdir /var/volatile/lock

# It is need to writable on udev : /run
mount -t tmpfs none $MODLOC
mount -t aufs -o br:$MODLOC:/run none /run

# And, do udev
/etc/init.d/udev start

# Debug
if [ `echo $COCON_DEBUG` ];
then
  echo " DEBUG: after initalize udev on initramfs."
  /bin/sh
fi

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
    echo "Boot from: $ROOT_DEVICE ($BOOT_FS), $SQSFILE"
   
    mount -o ro $ROOT_DEVICE $MOUNTLOC 

    if [ -n "$FROMISO" ];
    then
      # for GRUB2 iso loopback
      # Search opencocon iso file first.
      if ! [ -e $MOUNTLOC/$FROMISO ]; then
        echo "... is not contain $FROMISO."
        umount $MOUNTLOC
        return 1
      else
        # found ISO. Mount and search $SQSFILE.
        mount -o loop $MOUNTLOC/$FROMISO $ISOLOC
        if ! [ -e $ISOLOC/$SQSFILE ]; then
          echo "... is not contain $SQSFILE (on $FROMISO)"
          umount $ISOLOC
          sync
          umount $MOUNTLOC
          return 1
        else
          echo "found $SQSFILE on $FROMISO."
          # COCON_SQSFILE="$ISOLOC/$SQSFILE"
          # export COCON_SQSFILE
          COCON_ISO_ONDISK=1
          export COCON_ISO_ONDISK
        fi
      fi
    else 

      # just search squashfs file
      if ! [ -e $MOUNTLOC/$SQSFILE ]; then
        echo "... is not contain $SQSFILE, try next. "
        umount $MOUNTLOC
        return 1
      fi
      # COCON_SQSFILE="$MOUNTLOC/$SQSFILE"
      # export COCON_SQSFILE
    fi

    if [ `echo $COCON_COPYTORAM` ];
    then
      # Copy-to-RAM
      # TODO: disable for low memory
      echo "--- copy squashfs image to ram ---"
      mount -t tmpfs none $COPYTORAMLOC
      # cp $MOUNTLOC/$SQSFILE.md5sum $COPYTORAMLOC/$SQSFILE.md5sum
      if [ $COCON_ISO_ONDISK -eq 1 ];
      then
        cp $ISOLOC/$SQSFILE $COPYTORAMLOC/$SQSFILE
      else
        cp $MOUNTLOC/$SQSFILE $COPYTORAMLOC/$SQSFILE
      fi 

      # TODO : md5sum ha shibaraku oaduke
      # cd $COPYTORAMLOC && md5sum -cs $COPYTORAMLOC/$SQSFILE.md5sum -eq 0
      if [ $? -eq 0 ];
      then

        # copy ok. release the MOUNTLOC.
        if [ $COCON_ISO_ONDISK -eq 1 ];
        then
           umount -lf $ISOLOC >/dev/null 2>&1
        fi

        umount -lf $MOUNTLOC >/dev/null 2>&1
        echo "NOTE: Copy-to-RAM mode. It is safe to Eject or Unplug boot media."
        echo " (If you want to read cocon.cnf or firmware, please stay when by showing menu.)"
        SQS_DEVICE="$COPYTORAMLOC"

        # Eject CD drive
        if [ $BOOT_FS = "iso9660" -a -z "$COCON_NOEJECT" ];
        then
          echo "--- Eject CD device. ($ROOT_DEVICE) ---"
          fuser -k $ROOT_DEVICE
          sync
          eject.eject -s $ROOT_DEVICE
          # if [ $BOOT_FS = "iso9660" ];
          # then
          #  # wait
          #  sleep 20
          # fi
        fi

        mount -o remount,ro $COPYTORAMLOC

      else
        # failed. fallback to normal boot.
        echo "==============================================================="
        echo "WARNING: Trying Copy-to-RAM was failed. fallback to normal boot."
        echo "         Do not Eject or Unplug boot media."
        echo "==============================================================="
        sleep 5
        umount -lf $COPYTORAMLOC >/dev/null 2>&1
        unset COCON_COPYTORAM
        # TODO : is working?

        if [ $COCON_ISO_ONDISK -eq 1 ];
        then
          SQS_DEVICE="$ISOLOC"
        else
          # TODO
          SQS_DEVICE="$MOUNTLOC"
        fi

     fi
    else
      echo "WARNING: Do not Eject or Unplug boot media."

      if [ $COCON_ISO_ONDISK -eq 1 ];
      then
        SQS_DEVICE="$ISOLOC" 
      else
      # TODO
        SQS_DEVICE="$MOUNTLOC"
      fi
    fi 

    echo "--- mount squashfs ---"
    mount -o loop -t squashfs $SQS_DEVICE/$SQSFILE $UNIONLOC

    echo "--- union with aufs ---"
    mount -t tmpfs none $RAMLOC
    
    mount -t aufs -o br:$RAMLOC:$UNIONLOC none $NEWLOC

    echo "--- switch root ---"
    # on Linux 3.10, it seems don't stop udev.
#    /etc/init.d/udev stop
    umount -l /proc
    umount /sys
#    umount -l /dev
    mount -o bind /dev $NEWLOC/dev

    # Pivot to real opencocon
    # cd $UNIONLOC
    pivot_root $NEWLOC $NEWLOC/$OLDLOC
    exec chroot . /sbin/init <dev/console >dev/console 2>&1

}

scan_device()
{
  # Scan all available device/partitions
  cat /proc/diskstats | sort -r > $DISKSTATS_TMP

  while read maj min dev ex1 ex2 ex3 ex4 ex5 ex6 ex7 ex8 ex9 ex10 ex11; do
    if [ -z "$maj" -o "$maj" = "major" ]; then
        continue;
    fi

    get_partition_type
    if [ "$fstype" = "iso9660" -o "$fstype" = "vfat" -o "$fstype" = "ext3" -o "$fstype" = "ext4" ]; then
        # Comment following line to show all available block devices regardless of FS (for debug purposes)
        BOOT_FS="$fstype"
        export BOOT_FS
        boot_iso9660 $dev
        true
    fi


  done < $DISKSTATS_TMP
}

sleep 1
i=1
while test $i -le 20 ;
do
  echo "--- scanning root media (part $i)---"
  scan_device 
  i=`expr $i + 1` 
  sleep 3
done


echo " Fallback shell. "
exec /bin/sh
