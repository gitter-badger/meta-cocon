require recipes-graphics/drm/libdrm.inc

LIC_FILES_CHKSUM = "file://xf86drm.c;beginline=9;endline=32;md5=c8a3b961af7667c530816761e949dc71"

PR = "r0"

#SRC_URI += "file://installtests.patch \
#            file://GNU_SOURCE_definition.patch \
#           "

EXTRA_OECONF += " --enable-intel --enable-radeon --enable-nouveau-experimental-api "

