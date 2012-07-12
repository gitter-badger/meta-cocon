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


S = "${WORKDIR}/git"
SRCREV = "93459f842c2d8dc178a1954b8e05150fcb96ac9a"
