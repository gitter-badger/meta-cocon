DESCRIPTION = "LXDE Kbd and mouse config"
SECTION = "x11"
#DEPENDS = "xrandr"
LICENSE = "GPLv3"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "5bf563d04984ef2a147433f3bdda687b"
SRC_URI[sha256sum] = "481622f9f73c7d622a712df55d509a18805758ee002cbbc36efbd73bedd8205f"

inherit autotools gettext

#FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

#do_configure_prepend() {
#  mv ${S}/configure.in ${S}/configure.ac
#  sed -i \
#                -e '20a\AM_PROG_CC_C_O' \
#                ${S}/configure.ac
#}
