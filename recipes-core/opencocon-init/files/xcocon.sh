#!/bin/bash

# From general xinitrc

userresources=$HOME/.Xresources
usermodmap=$HOME/.Xmodmap
sysresources=/usr/lib/X11/xinit/.Xresources
sysmodmap=/usr/lib/X11/xinit/.Xmodmap

# merge in defaults and keymaps
if [ -f $sysresources ]; then
    xrdb -merge $sysresources
fi

if [ -f $sysmodmap ]; then
    xmodmap $sysmodmap
fi

if [ -f "$userresources" ]; then
    xrdb -merge "$userresources"
fi

if [ -f "$usermodmap" ]; then
    xmodmap "$usermodmap"
fi


# opencocon-local startup

ccl=$COCON_CLOCK
if [ $ccl ];
then
  exec pong-clock
  exit 0
fi


# Default running on matchbox window manager
matchbox-window-manager &
lxpanel &
nm-applet &

cxdmcp=$COCON_X
if [ $cxdmcp ];
then
  exec Xephyr -query $cxdmcp -fullscreen -once :1
fi


cvnc=$COCON_VNC
if [ $cvnc ];
then
  exec gvncviewer "$cvnc"
fi

cvncb=$COCON_VNC2
if [ $cvncb ];
then
  exec gtkvncviewer "$cvncb"
fi

crdp=$COCON_RDP
crdp_domain=$COCON_RDP_DOMAIN
crdp_user=$COCON_RDP_USERN
if [ $crdp ];
then
  # Login name
  if [ $crdp_user ];
  then
    OPTION="$OPTION -u $crdp_user"
  fi

  # Domain Name
  if [ $crdp_domain ];
  then
    OPTION="$OPTION -d $crdp_domain"
  fi

  # Running on xterm
  exec lxterminal -e xfreerdp $OPTION -f -x modem $crdp
fi

ccr=$COCON_CARAVAN
if [ $ccr ];
then
  # Coconcaravan
  exec web2
fi

ctr=$COCON_XTERM
if [ $ctr ];
then
  exec lxterminal
fi


