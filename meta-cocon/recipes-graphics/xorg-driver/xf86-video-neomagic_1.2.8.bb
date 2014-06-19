require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI[md5sum] = "cf95912edda11ac70b994c044e9308c5"
SRC_URI[sha256sum] = "50abf6ac02547900edeaa5073c5f6d2f153f12dd47067cc7e4758e1b74d78874"

