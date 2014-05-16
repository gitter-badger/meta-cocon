DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache gettext"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "30def9a0aa3c517e102295e8a7bc17fd"
SRC_URI[sha256sum] = "11cfe76f6241bbac556e57a6efc079b6e10dceea76a8bdaf4c749afdb81d15ab"


inherit autotools gettext

RDEPENDS_${PN} = "menu-cache gettext wireless-tools gdk-pixbuf"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

EXTRA_OECONF += "--with-plugins='volumealsa,batt,xkb,monitors'"

# --enable-indicator-support

