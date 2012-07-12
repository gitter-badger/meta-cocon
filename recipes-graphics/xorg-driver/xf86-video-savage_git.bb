require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f50f1289ca3b91a542a26ba5df51608"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-savage;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "de22eab9a21df80fe965dc37d21ba3ac2b9f5fd0"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
