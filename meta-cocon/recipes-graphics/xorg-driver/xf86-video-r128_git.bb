require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-r128;protocol=git;branch=master \
           file://xdriver_xf86-video-r128-cross-compile.patch \
"

S = "${WORKDIR}/git"
SRCREV = "4efc87f41d770c753ddf7f54fe334b6dbd7daf79"

#EXTRA_OECONF += "--enable-dri"

