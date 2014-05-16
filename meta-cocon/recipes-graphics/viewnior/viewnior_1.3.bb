DESCRIPTION = "Image Viewer"
SECTION = "x11"
#DEPENDS = "menu-cache"
LICENSE = "GPLv3"

SRC_URI = "http://cloud.github.com/downloads/xsisqox/Viewnior/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "273c379933ae3e74ad414fde00198695"
SRC_URI[sha256sum] = "46c97c1a85361519b42fe008cfb8911e66f709f3a3a988c11047ab3726889f10"

inherit autotools

#RDEPENDS_${PN} = "lxmenu-data menu-cache"
#FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

