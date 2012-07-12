require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NV display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-nv;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "b3d61828837661c9b383378a7d6006752659108b"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

