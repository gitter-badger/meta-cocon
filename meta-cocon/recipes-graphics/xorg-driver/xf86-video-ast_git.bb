require recipes-graphics/xorg-driver/xorg-driver-video.inc

PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=0b8c242f0218eea5caa949b7910a774b"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ast;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "0833e0086b9712b1c29571919899d5d17fea8382"
