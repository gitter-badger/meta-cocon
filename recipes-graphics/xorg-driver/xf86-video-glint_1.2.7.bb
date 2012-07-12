require recipes-graphics/xorg-driver/xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Glint display driver"
DEPENDS += " xf86dgaproto drm xf86driproto"
PR = "${INC_PR}.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=724772f5b1ac0f483904fa55275a5b85"

SRC_URI[md5sum] = "c4edb998485020debffeafc491ea759e"
SRC_URI[sha256sum] = "9aa9689436fc78a71145d4caeaf63b0e80f9abd54e9b4a3066f62ee5b334c359"

