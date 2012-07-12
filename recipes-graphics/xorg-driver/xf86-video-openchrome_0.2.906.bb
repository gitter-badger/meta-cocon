require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
DEPENDS += "libxvmc"
PE = "1"
PR = "${INC_PR}.1"


do_configure_prepend() {
        rm -f ${S}/acinclude.m4 || true
}

LIC_FILES_CHKSUM = "file://COPYING;md5=ed28020670498bb992812791b7aa3cca"

SRC_URI[md5sum] = "244507baf1900f1e923604c4a0f05925"
SRC_URI[sha256sum] = "e7558edc144a08371493432014a7b88ee26ec35d00ef96f2ea24bd7872b0ff41"

