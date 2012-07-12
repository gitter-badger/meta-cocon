require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for Voodoo/Voodoo2"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=b2a2c00d9810cf8f963852e6362fcabc"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-voodoo;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "8c1121725c4dc1a81dd1af74b83405a1cb69562e"
