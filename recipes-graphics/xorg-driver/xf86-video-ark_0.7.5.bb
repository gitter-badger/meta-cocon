require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ark display driver"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=bdb6aed1d4651e3c08a43c49b9b286d7"

do_configure_prepend() {
        sed -i \
                -e s:'#include "mibstore.h"':'':g \
                ${S}/src/ark_driver.c
}

SRC_URI[md5sum] = "2e9809b5ae3f01a56be0d6e5441da03c"
SRC_URI[sha256sum] = "c690e046f34a393aac1c8d9616b4790e93cda60a460b00b9597d322175dbe51e"

