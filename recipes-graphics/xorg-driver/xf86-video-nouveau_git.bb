require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Nouveau Xorg driver for NVIDIA chips"
DEPENDS += "libdrm"
RDEPENDS_${PN} = "xserver-xorg-extension-dri xserver-xorg-extension-dri2 xserver-xorg-extension-glx mesa-dri"
PE = "2"
PV = "gitr${SRCPV}"
PR = "${INC_PR}.5"

SRC_URI = "git://anongit.freedesktop.org/nouveau/xf86-video-nouveau;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "ab7291d368ddc66ad21c5ad5caa0faeee42ccaf1"

EXTRA_OECONF += " --enable-kms "

LIC_FILES_CHKSUM = "file://COPYING;md5=4641deddaa80fe7ca88e944e1fd94a94"

