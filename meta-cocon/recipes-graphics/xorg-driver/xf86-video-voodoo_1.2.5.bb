require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for Voodoo/Voodoo2"
DEPENDS += " xf86dgaproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=b2a2c00d9810cf8f963852e6362fcabc"

SRC_URI[md5sum] = "fe71b83352cb96c41ff6a73a46a05e20"
SRC_URI[sha256sum] = "9e3eb8a3fdcc60ce4f7c37649188cfa67dcf25cda3a85d8027588458bb3fd7e8"
