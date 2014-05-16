require recipes-graphics/xorg-driver/xorg-driver-video.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=e7f3e39474aeea5af381a8e103dafc36"

DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-geode;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "ed0b153f320a95a11bd561726d2405823573500e"

COMPATIBLE_HOST = "i.86.*-linux"
