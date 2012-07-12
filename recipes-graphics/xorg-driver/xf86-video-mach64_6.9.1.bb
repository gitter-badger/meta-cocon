require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Intel i8xx, i9xx display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

SRC_URI[md5sum] = "8484c18f08e77564a56ccbf226694038"
SRC_URI[sha256sum] = "9f6ad49f07c8785a64caac6f4aaf58fc7746a24b718491d047c45bc1ee9e834e"

