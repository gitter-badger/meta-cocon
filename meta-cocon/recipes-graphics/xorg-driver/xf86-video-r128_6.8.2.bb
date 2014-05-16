require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"
PE = "1"
PR = "${INC_PR}.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

#SRC_URI[md5sum] = "99299cbf45abfd86e21b34eb4217d6f5"
#SRC_URI[sha256sum] = "8be3baa8d3b19e3a05f00a53bf35784e144dc2ad14c358f97870c072e634e44c"


SRC_URI[md5sum] = "31e0358b5d1189e3f30f5b11e9b86865"
SRC_URI[sha256sum] = "7b41135c3d177e61644573e5c16e35fd9eff98b4d6685c9c6de9e33401e904b1"

# Patch from buildroot
SRC_URI += "file://xdriver_xf86-video-r128-cross-compile.patch "

#EXTRA_OECONF += "--enable-dri"

do_compile_prepend() {
        sed -i \
                -e s:'\-O2':'\-O0':g \
                ${S}/src/Makefile
        sed -i \
                -e s:'\-O1':'\-O0':g \
                ${S}/src/Makefile
}

