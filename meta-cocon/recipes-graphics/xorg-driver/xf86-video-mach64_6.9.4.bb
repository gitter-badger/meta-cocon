require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI Mach64 display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"
PE = "1"
#PR = "${INC_PR}.4"

LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

#SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-mach64;protocol=git;branch=master 
SRC_URI += "file://xdriver_xf86-video-mach64-cross-compile.patch "

#S = "${WORKDIR}/git"
#SRCREV = "ec6ee6a112dc38cab563779583944dba9393f385"


#EXTRA_OECONF += " --enable-dri --disable-xaa --enable-exa"

do_compile_prepend() {
        sed -i \
                -e s:'\-O2':'\-O0':g \
                ${S}/src/Makefile
        sed -i \
                -e s:'\-O1':'\-O0':g \
                ${S}/src/Makefile
}

SRC_URI[md5sum] = "d645197cbf238ac0427c3904eafdce2f"
SRC_URI[sha256sum] = "97f108b8d7c0a8426bef9562683323ab6369956f18b0e220ee0d1a66b740855e"
