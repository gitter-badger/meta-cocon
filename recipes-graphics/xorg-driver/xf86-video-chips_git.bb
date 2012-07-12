require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Chips display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-chips;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "989cf4f1fb2ac57f38d363734b71a5cf749db146"

LIC_FILES_CHKSUM = "file://COPYING;md5=d16ab8e6e1c8f1eaca1ef57449f284b2"
