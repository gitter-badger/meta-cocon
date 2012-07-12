require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X11 driver supporting cards based on the V1000 or the V2x00."
PE = "1"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=1f82ff47b53d054af9757517c438fabb"


SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-rendition;protocol=git;branch=master \
          "

S = "${WORKDIR}/git"
SRCREV = "7b26793ba2572c412f03e9a4acf83237fbec71bd"
