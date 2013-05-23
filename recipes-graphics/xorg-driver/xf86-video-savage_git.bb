require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"
PE = "2"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master \
           file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch \
           file://03_request_16bit_depth.diff \
"


S = "${WORKDIR}/git"
SRCREV = "ca9718a887ecbc59b76869af673791ab591b849b"

EXTRA_OECONF += " --disable-dri"
