DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "libwnck menu-cache glib-2.0 gtk+ gdk-pixbuf"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"


inherit autotools gettext

RDEPENDS_${PN} = "menu-cache gettext wireless-tools gdk-pixbuf"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

EXTRA_OECONF += "--with-plugins='volumealsa,batt,xkb,monitors'"

# --enable-indicator-support

SRC_URI[md5sum] = "b074182b6effe46ccac97bf178de4e32"
SRC_URI[sha256sum] = "f9ba6d0b825f7b99de045c3371738792bf9f3604af66bef4d98d783461c60a48"

