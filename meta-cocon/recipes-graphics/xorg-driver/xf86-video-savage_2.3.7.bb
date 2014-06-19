require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"

# Patch from buildroot
SRC_URI += "file://xdriver_xf86-video-savage-2.2.1-cross-compile.patch  \
            file://03_request_16bit_depth.diff \
"

#do_compile_prepend() {
#        sed -i \
#                -e s:'\-O2':'\-O0':g \
#                ${S}/src/Makefile
#        sed -i \
#                -e s:'\-O1':'\-O0':g \
#                ${S}/src/Makefile
#}

EXTRA_OECONF += " --enable-dri"

SRC_URI[md5sum] = "e813271ab43cc6a95ac0ab252b90a885"
SRC_URI[sha256sum] = "041d4205c9222c1780fba6e0e397a559aed393b7a7991b58fa79ba8cccc54a44"
