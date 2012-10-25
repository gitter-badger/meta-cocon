#!/bin/bash

/sbin/modprobe zram

# Run udev daemon
/etc/init.d/udev-cocon

# mount missing /dev/pts
mkdir /dev/pts
mount -t devpts none /dev/pts

# zram
COCON_MEM_MB=`free -m | grep "Mem:" | sed -r "s/Mem://" | sed -r "s/^[[:space:]]*([0-9]+).*/\\1/"`
echo "Memory: $COCON_MEM_MB MB"

if [ "$COCON_MEM_MB" -lt 240 ];
then
  echo $(($COCON_MEM_MB*1048576)) > /sys/block/zram0/disksize
  mkswap -v1 /dev/zram0
  swapon /dev/zram0
fi

# Enable Framebuffer console : needed for i810
if [ -c /dev/fb0 ];
then
  /sbin/modprobe fbcon
fi

# Daemon
/etc/init.d/dbus-1 start
/etc/init.d/connman start

# Keymap (TODO)
/usr/bin/loadkeys jp106

