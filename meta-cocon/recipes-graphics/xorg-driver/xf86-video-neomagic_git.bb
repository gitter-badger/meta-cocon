require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"
PE = "4"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=3a6358ddf387f4be24801a5337a021a8"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-neomagic;protocol=git;branch=master \
          "

do_compile_prepend() {
        sed -i \
                -e s:'\-O2':'\-O0':g \
                ${S}/src/Makefile
        sed -i \
                -e s:'\-O1':'\-O0':g \
                ${S}/src/Makefile
}

S = "${WORKDIR}/git"
SRCREV = "005d61313e989bf054b1cc2190f1c743362d86ff"
