#!/bin/bash

MOUNTLOC="/media/realroot"
UNIONLOC="/media/union"
RAMLOC="/media/ram"
OLDLOC="/media/cf"

#if [ ! "$COCON_CDSHUTDOWN" ];
#then
    echo "--- reverse pivot"
    COCON_CDSHUTDOWN=1
    # reverse pivot (to unmount)
    #/bin/sh
    pivot_root $OLDLOC $OLDLOC/$UNIONLOC
#    exec chroot . /clean "$@" <dev/console >dev/console 2>&1 
#fi

    # kill processs
    PID="pidof clean"
for pid in `ps | grep -v "PID" | egrep -v "\[.*\]" | grep -F -v mount | sed -r "s/^[[:space:]]*([0-9]+).*/\\1/"`;
do
  if [ $pid -lt `$PID` ];
  then
    if [ $pid -ne 1 ];
    then
      LIST="$LIST $pid"
    fi
  fi
done
    # Kill processes
kill -s TERM $LIST >/dev/null 2>&1
#sleep 2
kill -s KILL $LIST >/dev/null 2>&1
sync

    # unmount file system
    umount -lf $UNIONLOC/proc
    umount -lf $UNIONLOC/sys
    umount -lf $UNIONLOC/tmp
    umount -lf $UNIONLOC/dev/pts
    umount -lf $UNIONLOC/dev
    umount -lf $UNIONLOC
    umount -lf $RAMLOC
    umount -lf $UNIONLOC
    umount -lf $MOUNTLOC

    # Eject CD drive
    if [ $BOOT_FS = "iso9660" ];
    then 
      echo "--- eject CD device. ($ROOT_DEVICE) ---"
      echo "Press [Enter] key (or wait 2min) to turn off computer."
      echo "Thank you for using opencocon, kon-kon!"
      eject -sT $ROOT_DEVICE
      # eject -m?
      read -t 120
    fi

    # and Power off
    /sbin/poweroff


/bin/sh
