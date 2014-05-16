require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += "xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=225ca1644e92badb31a40ef755bf2364"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-xgixp;protocol=git;branch=master \
           file://xdriver_xf86-video-xgixp-cross-compile.patch"

S = "${WORKDIR}/git"
SRCREV = "a84753dd495bcfd724406cae470e17d0c561d0c3"

EXTRA_OECONF += "--enable-dri"

