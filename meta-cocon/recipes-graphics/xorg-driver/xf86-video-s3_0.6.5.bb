require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- legacy S3 display driver"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=0eae1e9f9b6904bf113c02c911019b1a"

# Patch from Arch Linux
SRC_URI += "file://build-fix.diff "

SRC_URI[md5sum] = "37248d5c5a04d7f91c6f634cc592b304"
SRC_URI[sha256sum] = "4778cd4f1d61490c3562f9be03664576f065fa3acf22fe0d0689212d7ea3ad39"
