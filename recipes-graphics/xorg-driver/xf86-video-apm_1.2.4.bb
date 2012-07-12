require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "This is the Alliance Promotion driver for XFree86 4.0+"
DEPENDS += " xf86rushproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=0b302c1eb730ff7a191f2cbdc952f689"

SRC_URI[md5sum] = "7692dac140c15172935872a77417bed2"
SRC_URI[sha256sum] = "ae65982961fe884728497db9b805123d486d2aade2ba8e7bba9a3ee9dccf4302"

