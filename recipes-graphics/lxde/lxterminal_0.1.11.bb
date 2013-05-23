DESCRIPTION = "LXDE Terminal"
SECTION = "x11"
DEPENDS = "vte"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "fd9140b45c0f28d021253c4aeb8c4aea"
SRC_URI[sha256sum] = "f495166b308a96e8c30c8892b33ab163f3865253a9bbd4bdac462f974fda7253"


inherit autotools

RDEPENDS_${PN} = "vte"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

