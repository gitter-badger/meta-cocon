#!/bin/bash

export HOME=/home/root

SELECT=/tmp/cocon.menu.select
HOSTN=/tmp/cocon.menu.host
USERN=/tmp/cocon.menu.usern
DOMAIN=/tmp/cocon.menu.domain
ABOUT=/usr/share/doc/cocon/about.txt

dialog --menu "opencocon v3 (hyper experimental)" 20 40 25 \
XEPHYR "Connect XDMCP" \
RDP "Connect RDP" \
VNC "Connect VNC" \
VNC2 "Connect VNC (Alt.)" \
WWW "Web Browser" \
XDMCP "Connect XDMCP (Classic)" \
XSH "X Shell" \
CLOCK "Pong-Clock" \
ABOUT "About opencocon" \
OFF "Power Off" 2>$SELECT

select=$(<"$SELECT")

case $select in 
XDMCP)

  # Classic XDMCP

  dialog --inputbox "Enter hostname to connect" 8 40 2>$HOSTN

  # Direct connect to X
  hostn=$(<$HOSTN)
  X -query $hostn -once
  ;;

XEPHYR)

  # XDMCP via XEPHYR

  dialog --inputbox "Enter hostname to connect" 8 40 2>$HOSTN

  hostn=$(<$HOSTN)
  export COCON_X=$hostn
  xinit
  unset COCON_X
  ;;


VNC)

  # Connect VNC via gtk-vnc

  dialog --inputbox "Enter hostname:display to connect" 8 40 2>$HOSTN
  hostn=$(<$HOSTN)

  export COCON_VNC=$hostn
  xinit
  unset COCON_VNC
  ;;

VNC2)
   
  # Connect VNC via libvncclient (Alt.)

  dialog --inputbox "Enter hostname:display to connect" 8 40 2>$HOSTN
  hostn=$(<$HOSTN)

  export COCON_VNC2=$hostn
  xinit
  unset COCON_VNC2
  ;;


RDP)

  # Connect RDP with xfreerdp

  dialog --inputbox "Enter hostname(:port) to connect" 8 40 2>$HOSTN
  dialog --inputbox "Enter login username" 8 40 2>$USERN
  dialog --inputbox "Enter Domain name (if not use domain name, just enter)" 8 40 2>$DOMAIN
  hostn=$(<$HOSTN)
  usern=$(<$USERN)
  rdpdomain=$(<$DOMAIN)
  export COCON_RDP=$hostn
  export COCON_RDP_USERN=$usern
  export COCON_RDP_DOMAIN=$rdpdomain

  xinit

  unset COCON_RDP
  unset COCON_RDP_USERN
  unset COCON_RDP_DOMAIN
  ;;

WWW)

  # Web Browser

  export COCON_CARAVAN=1
  xinit
  unset COCON_CARAVAN
  ;;

CLOCK)

  # 

  export COCON_CLOCK=1
  xinit
  unset COCON_CLOCK
  ;;


SH)
  echo "Type exit to back menu."
  /bin/sh
  ;;

XSH)
  export COCON_XTERM=1
  xinit
  unset COCON_XTERM
  ;;

ABOUT)
  about=$(<$ABOUT)
  dialog --msgbox "$about" 20 60
  ;;

OFF)
  modprobe apm power_off=1
  /sbin/poweroff
  ;;

esac

