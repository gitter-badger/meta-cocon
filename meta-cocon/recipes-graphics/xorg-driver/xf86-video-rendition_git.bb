require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver supporting cards based on the V1000 or the V2x00."

LIC_FILES_CHKSUM = "file://COPYING;md5=1f82ff47b53d054af9757517c438fabb"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-rendition;protocol=git;branch=master \
          "

# TODO : Split another package 
#FILES_${PN} += "${libdir}/xorg/modules/v*0002d.uc"

S = "${WORKDIR}/git"
SRCREV = "3a3ee1c45e54a808947cc26ca11f0a5299571053"
