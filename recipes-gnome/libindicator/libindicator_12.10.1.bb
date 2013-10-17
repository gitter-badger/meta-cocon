DESCRIPTION = "Ayatana indicators project library"
LICENSE = "GPLv3"
SECTION = "x11/gnome"
DEPENDS = "gtk+"
PR = "r0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
EXTRA_OECONF = "--with-gtk=2"



inherit autotools
SRC_URI = "http://launchpad.net/libindicator/12.10/${PV}/+download/libindicator-${PV}.tar.gz"

SRC_URI[md5sum] = "5fd4d6bab339fc9611078b64c44a85a8"
SRC_URI[sha256sum] = "b2d2e44c10313d5c9cd60db455d520f80b36dc39562df079a3f29495e8f9447f"
