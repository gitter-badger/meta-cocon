require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI Mach64 display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-mach64;protocol=git;branch=master \
           file://xdriver_xf86-video-mach64-cross-compile.patch "

S = "${WORKDIR}/git"
SRCREV = "ec6ee6a112dc38cab563779583944dba9393f385"


EXTRA_OECONF += " --disable-dri --disable-xaa --enable-exa"

