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

# Force Framebuffer driver if boot option contains "forcefb*"
if [ "`cat /proc/cmdline | grep forcefb`" ];
then
  ln -s /usr/share/cocon/card-fbdev.conf /etc/X11/xorg.conf.d/card-fbdev.conf
else
  rm /etc/X11/xorg.conf.d/card-fbdev.conf
fi


# Force 800x600 16bit color if contains "forcesvga"
if [ "`cat /proc/cmdline | grep forcesvga`" ];
then
  ln -s /usr/share/cocon/defaultdepth.conf /etc/X11/xorg.conf.d/defaultdepth.conf
else
  rm /etc/X11/xorg.conf.d/defaultdepth.conf
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

# Stop before running X
if [ "`cat /proc/cmdline | grep stopbeforex`" ];
then
  exec /bin/sh
fi

