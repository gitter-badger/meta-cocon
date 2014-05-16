DESCRIPTION = "LXDE RandR"
SECTION = "x11"
DEPENDS = "xrandr"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "8a7391581541bba58839ac11dbf5b575"
SRC_URI[sha256sum] = "fb8139478f6cfeac6a2d8adb4e55e8cad099bfe2da7c82253c935ba719f9cf19"

inherit autotools gettext


LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

do_configure_prepend() {
  mv ${S}/configure.in ${S}/configure.ac
  sed -i \
                -e '20a\AM_PROG_CC_C_O' \
                ${S}/configure.ac
}
