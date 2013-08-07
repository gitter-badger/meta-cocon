require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"
PE = "4"
PR = "${INC_PR}.1"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master \
           file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch  \
           file://03_request_16bit_depth.diff \
"


S = "${WORKDIR}/git"
SRCREV = "44581aef5f878e7f2b34d5693d50ef75263b195c"

#SRCREV = "de22eab9a21df80fe965dc37d21ba3ac2b9f5fd0"

#EXTRA_OECONF += " \
#  ac_cv_file__usr_include_xorg_dri_h=yes \
#  ac_cv_file__usr_include_xorg_sarea_h=yes \
#  ac_cv_file__usr_include_xorg_dristruct_h=yes \
#"



do_compile_prepend() {
        sed -i \
                -e s:'\-O2':'\-O0':g \
                ${S}/src/Makefile
        sed -i \
                -e s:'\-O1':'\-O0':g \
                ${S}/src/Makefile
}

EXTRA_OECONF += " --disable-dri --disable-xaa"
