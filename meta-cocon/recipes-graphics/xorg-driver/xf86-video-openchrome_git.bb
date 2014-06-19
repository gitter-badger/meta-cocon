require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- openchrome display driver"
DEPENDS += "libxvmc"


do_configure_prepend() {
        rm -f ${S}/acinclude.m4 || true
}

LIC_FILES_CHKSUM = "file://COPYING;md5=ed28020670498bb992812791b7aa3cca"

SRC_URI = "git://anongit.freedesktop.org/openchrome/xf86-video-openchrome;protocol=git;branch=master \
	   file://flora-se210.patch \
          "

S = "${WORKDIR}/git"
SRCREV = "46a4ef37a1fc793ea85950f9579783e9af3a6b36"


