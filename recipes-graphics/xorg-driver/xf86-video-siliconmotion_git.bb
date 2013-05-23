require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiliconMotion display driver"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=3893e77db70569921f6d79c387b5748a"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-siliconmotion;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "f19d7e463c30f1364e82e8c9f87b8a8407d53680"
