require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- MGA display driver"
PE = "1"
PR = "${INC_PR}.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=bc1395d2cd32dfc5d6c57d2d8f83d3fc"

# Patch from https://bugs.freedesktop.org/show_bug.cgi?id=57606
SRC_URI += "file://xf86-video-mga-cross-compile.patch "

SRC_URI[md5sum] = "f543877db4e260d8b43c7da3095605ed"
SRC_URI[sha256sum] = "3f89ce250eea93f0de890954687790e06c0bab9e3e303df393e8759a187eca6c"

EXTRA_OECONF += " --enable-dri"

