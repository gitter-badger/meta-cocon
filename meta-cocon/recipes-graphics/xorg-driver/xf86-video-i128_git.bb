require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- i128 display driver"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=47dae2fb2926bd08adffd5128f45190c"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-i128;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "c87753733a6e1f85d1d037dced0b47ce0cf41658"

