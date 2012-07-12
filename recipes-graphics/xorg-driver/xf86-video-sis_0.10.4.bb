require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=cbbdd887d04deb501076c22917e2030d"

SRC_URI[md5sum] = "e1dda5365ad28ef3165fd0ed25952d9c"
SRC_URI[sha256sum] = "4e841080ea524f37d887ef4ee50df5b9f7f5b417abddc9eb8ddad19128c0b10d"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
