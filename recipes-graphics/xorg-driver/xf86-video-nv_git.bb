require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- NV display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-nv;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "fc78fe98222b0204b8a2872a529763d6fe5048da"

LIC_FILES_CHKSUM = "file://COPYING;md5=5f26d42045c078fef2e284111eabdd31"

