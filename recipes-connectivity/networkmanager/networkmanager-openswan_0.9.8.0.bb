DESCRIPTION = "NetworkManager"
SECTION = "net/misc"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "networkmanager libnl dbus dbus-glib wireless-tools polkit gnutls util-linux ppp libglade gnome-keyring"
RDEPENDS_${PN} = "wpa-supplicant dhcp-client \
           ${@base_contains('COMBINED_FEATURES', '3gmodem', 'ppp', '', d)} \
           "
LIC_FILES_CHKSUM = "file://COPYING;md5=100d5a599bead70ddcd70dcd73f2e29c"

EXTRA_OECONF = " \
		--with-distro=debian \
		--with-crypto=gnutls \
		--disable-more-warnings"

inherit autotools pkgconfig

PR = "r0"

SRC_URI += "${GNOME_MIRROR}/NetworkManager-openswan/0.9/NetworkManager-openswan-${PV}.tar.xz \
"

S = "${WORKDIR}/NetworkManager-openswan-${PV}"

FILES_${PN} += " \
		${libdir}/NetworkManager/*.so \
		${datadir}/gnome-vpn-properties \
		${datadir}/icons "

SRC_URI[md5sum] = "6a373868f85ac3b7c953f7fd6c76e637"
SRC_URI[sha256sum] = "fc627deffb5d880e1d203f67a63689c9d75a0a8ed309b537a39fb8699a819fce"

