require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=aabff1606551f9461ccf567739af63dc"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ati;protocol=git;branch=master \
          "

FILES_${PN} += "\
  ${libdir}/xorg/modules/multimedia/*.so \
"

FILES_${PN}-dbg += "\
  ${libdir}/xorg/modules/multimedia/.debug/*.so \
" 

EXTRA_OECONF += " --disable-xaa "

S = "${WORKDIR}/git"
# v5
#SRCREV = "343b01c9bf35b125cd0c3df8db7c01a5fb227bda"
# v6
SRCREV = "cf377c991f4c1cd4eee1a8530ba9fdf6f9f63301"

