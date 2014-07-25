# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient on Raspberry Pi (X.org depends library)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
consolekit \
dbus-x11 \
encodings \
font-alias \
font-util \
freetype \
libdricore \
libdrm-kms \
liberation-fonts \
libgbm \
libglapi \
jpeg \
mesa-driver-swrast \
setxkbmap \
ttf-bitstream-vera \
ttf-koruri \
x11perf \
xauth \
xcb-util-image \
xcb-util-keysyms \
xcb-util-renderutil \
xcb-util-wm \
xdpyinfo \
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xf86-video-fbdev \
xinit \
xinput-calibrator \
xmodmap \
xorg-minimal-fonts \
xrandr \
xserver-xorg \
xserver-xorg-extension-dbe \
xserver-xorg-extension-extmod \
xserver-xorg-extension-glx \
xserver-xorg-fbdev \
xserver-xorg-module-exa \
xserver-xorg-module-libint10 \
xserver-xorg-module-libwfb \
xserver-xorg-multimedia-modules \
"


