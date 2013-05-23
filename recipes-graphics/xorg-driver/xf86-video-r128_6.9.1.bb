require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

SRC_URI[md5sum] = "99299cbf45abfd86e21b34eb4217d6f5"
SRC_URI[sha256sum] = "8be3baa8d3b19e3a05f00a53bf35784e144dc2ad14c358f97870c072e634e44c"

# Patch from buildroot
SRC_URI += "file://xdriver_xf86-video-r128-cross-compile.patch "

EXTRA_OECONF += "--enable-dri"
