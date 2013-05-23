require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
DEPENDS += "libxvmc"
PE = "1"
PR = "${INC_PR}.1"


do_configure_prepend() {
        rm -f ${S}/acinclude.m4 || true
}

LIC_FILES_CHKSUM = "file://COPYING;md5=ed28020670498bb992812791b7aa3cca"

SRC_URI = "git://anongit.freedesktop.org/openchrome/xf86-video-openchrome;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "c27f9fedd1ffb3462154dc309afdf10b5b6ff50d"


