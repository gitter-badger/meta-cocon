require recipes-graphics/xorg-driver/xorg-driver-video.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=0b8c242f0218eea5caa949b7910a774b"

SRC_URI = "git://anongit.freedesktop.org/xorg/driver/xf86-video-ast;protocol=git;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "94640946015eb6611ff9bf8daf49e10479351fac"
