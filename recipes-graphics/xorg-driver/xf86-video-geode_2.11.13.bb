require recipes-graphics/xorg-driver/xorg-driver-video.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=e7f3e39474aeea5af381a8e103dafc36"

DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PR = "${INC_PR}.0"

SRC_URI[md5sum] = "0c5a3cac3531aec0eae7f5f6b3212eb4"
SRC_URI[sha256sum] = "c320a2a314fc6c7a5d2dfb6a52c8fec23ab8f1b99c689ca618f02c279a64e226"

COMPATIBLE_HOST = "i.86.*-linux"
