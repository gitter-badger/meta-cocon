require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for Voodoo/Voodoo2"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=b2a2c00d9810cf8f963852e6362fcabc"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-voodoo;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "e505d6b24873046285b18446df43ef505b650663"
