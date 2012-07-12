require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI[md5sum] = "e5f25c01492d96ddd0171454a8e6bd39"
SRC_URI[sha256sum] = "b19ed2a33e8d9a3e2bfc1ae3e8ff49031b7d34dec786e4a5e060e68e48649888"

