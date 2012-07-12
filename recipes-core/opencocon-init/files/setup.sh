#!/bin/bash

# Run udev daemon
/etc/init.d/udev-cocon

# mount missing /dev/pts
mkdir /dev/pts
mount -t devpts none /dev/pts

# Enable Framebuffer console : needed for i810
if [ -c /dev/fb0 ];
then
  /sbin/modprobe fbcon
fi

# Daemon
/etc/init.d/dbus-1 start
# /etc/init.d/NetworkManager start
echo "Running NetworkManager..."
/usr/sbin/NetworkManager --log-level=ERR --log-domains=NONE 1>/dev/null 2>/dev/null &

# Keymap (TODO)
/usr/bin/loadkeys jp106

# Workaround : User home directory
HOME="/home/root"
export HOME

# Workaround:
# sleep 5
