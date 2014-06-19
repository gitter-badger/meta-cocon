require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NV display driver"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-nv;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "0b6619fec39fada995646fb95bb25e72d3c9a491"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

