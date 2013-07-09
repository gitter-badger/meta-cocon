require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.6"

LIC_FILES_CHKSUM = "file://COPYING;md5=aabff1606551f9461ccf567739af63dc"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ati;protocol=git;branch=master \
           file://radeon_dri2.patch \
          "

FILES_${PN} += "\
  ${libdir}/xorg/modules/multimedia/*.so \
"

FILES_${PN}-dbg += "\
  ${libdir}/xorg/modules/multimedia/.debug/*.so \
" 

EXTRA_OECONF += " --enable-exa --enable-dri --enable-kms "

do_configure_prepend() {
        sed -i \
                '/USE_XAA, 1/d' \
                ${S}/configure.ac
}

do_compile_prepend() {
        sed -i \
                -e s:'\-O2':'\-O0':g \
                ${S}/src/Makefile
        sed -i \
                -e s:'\-O1':'\-O0':g \
                ${S}/src/Makefile
}

S = "${WORKDIR}/git"
# v5
SRCREV = "93459f842c2d8dc178a1954b8e05150fcb96ac9a"
# v6
#SRCREV = "cf377c991f4c1cd4eee1a8530ba9fdf6f9f63301"
# v7a   6.14.6
#SRCREV = "008eb209d506ed7195fd544dfa91be9783946fd5"
