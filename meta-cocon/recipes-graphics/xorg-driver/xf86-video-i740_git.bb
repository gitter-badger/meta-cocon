require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- i740 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=c85da4d100605ac6d8d47d47eb2bf191"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-i740;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "b4a3e260f5123d6fbd4670776232af5405a7c5a2"

