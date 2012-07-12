require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=225ca1644e92badb31a40ef755bf2364"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgixp;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "8130a2ac8332ff1f83f9f35acca3053d4076f443"
