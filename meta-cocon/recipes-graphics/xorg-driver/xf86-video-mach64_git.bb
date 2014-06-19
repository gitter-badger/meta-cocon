require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI Mach64 display driver"
DEPENDS += " virtual/libx11 libxvmc drm xf86driproto"

LIC_FILES_CHKSUM = "file://COPYING;md5=be79d1b174a1e5b7e9303201e18d45f4"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-mach64;protocol=git;branch=master \
          file://xdriver_xf86-video-mach64-cross-compile.patch"

S = "${WORKDIR}/git"
SRCREV = "2c83b465b336a012f2d2716940bf483358388000"


EXTRA_OECONF += " --enable-dri --disable-xaa --enable-exa"

# do_compile_prepend() {
#         sed -i \
#                 -e s:'\-O2':'\-O0':g \
#                 ${S}/src/Makefile
#         sed -i \
#                 -e s:'\-O1':'\-O0':g \
#                 ${S}/src/Makefile
# }

