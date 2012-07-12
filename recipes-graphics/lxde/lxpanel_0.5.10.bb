DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache gettext"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "1bf3cce2a2d01c211f6897c42e8dd0bc"
SRC_URI[sha256sum] = "5f003c38035009fbfcdbb1f1ed8d15cbbdd1216310d1d67a843fe632049996d4"


inherit autotools gettext

RDEPENDS_${PN} = "libwnck menu-cache gettext"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

