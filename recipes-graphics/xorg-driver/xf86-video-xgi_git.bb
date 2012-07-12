require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=2b1ee283c95fdba674307f121936ca9a"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgi;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "28a36e33ac219f82b765f392365abff68cb3b22d"
