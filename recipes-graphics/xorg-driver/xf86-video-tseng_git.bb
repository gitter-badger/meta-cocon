require recipes-graphics/xorg-driver/xorg-driver-video.inc

PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=0a077234e3915957b0b4a1f0ff3f10b7"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tseng;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "8f41e5d8bb40d6bb184b4806b701a3e11caf43c3"
