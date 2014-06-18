require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- r128 display driver"
PE = "1"
# PR = "${INC_PR}.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=7afbe929192be6cccb50f81b968fd23a"

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

SRC_URI[md5sum] = "2e906d856a1c477bde000254b142445c"
SRC_URI[sha256sum] = "8b2d295f1842d07304a75da1cfb9bf139b320a6539970eaf8d5ecc010cd36ee0"

