require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Cirrus display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=6ddc7ca860dc5fd014e7f160ea699295"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-cirrus;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "f0d278b48a659d4811f5494bf7de4a84e9c5880f"

