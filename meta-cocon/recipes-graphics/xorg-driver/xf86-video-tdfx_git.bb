require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += " drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=41f74bf6ac6803f497df136f0896153a"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-tdfx;protocol=git;branch=master \
           file://xdriver_xf86-video-tdfx-1.4.0.patch"

S = "${WORKDIR}/git"
SRCREV = "d8873445199bf1d229503ff1d12c6a2f3f23c863"

EXTRA_OECONF += " --enable-dri"
