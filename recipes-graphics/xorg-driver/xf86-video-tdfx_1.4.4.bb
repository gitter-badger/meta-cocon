require recipes-graphics/xorg-driver/xorg-driver-video.inc

DEPENDS += " drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=41f74bf6ac6803f497df136f0896153a"

SRC_URI[md5sum] = "890d6c96c12e91e22b4ceaa9ef93b442"
SRC_URI[sha256sum] = "e0b931dea0fb1ebfaa628a3dc07bf6945b377d3f7bbfd3a43ca4c80c46d48f88"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
