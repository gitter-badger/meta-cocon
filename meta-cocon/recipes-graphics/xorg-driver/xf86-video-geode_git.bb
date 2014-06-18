require recipes-graphics/xorg-driver/xorg-driver-video.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=e7f3e39474aeea5af381a8e103dafc36"

DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PR = "${INC_PR}.0"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-geode;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "70b131d09b7d21df1d1ffcf6a4e50d3086924228"

COMPATIBLE_HOST = "i.86.*-linux"
