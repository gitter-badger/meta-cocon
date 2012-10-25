DESCRIPTION = "GTK+ applet for NetworkManager" 
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

DEPENDS = "polkit-gnome libnotify networkmanager dbus-glib libglade gconf gnome-keyring libgnome-keyring iso-codes libnotify"

SRC_URI = " http://ftp.gnome.org/pub/GNOME/sources/network-manager-applet/0.9/network-manager-applet-${PV}.tar.bz2"

inherit gnome

SRC_URI[md5sum] = "feaf2c8427d23924dde7de52ff4c5078"
SRC_URI[sha256sum] = "287301692224cc1bb20abe8bc52140461f565e58898a99daef11a188bb29b362"

# GTK2.x mode
EXTRA_OECONF += "--with-gtkver=2 \
                 --with-bluetooth=no \
                "

do_configure_append() {
        rm config.log
        # Sigh... --enable-compile-warnings=no doesn't actually turn off -Werror
        for i in $(find ${S} -name "Makefile") ; do
            sed -i -e s:-Werror::g $i
        done
}

RDEPENDS_${PN} =+ "networkmanager"
RRECOMMENDS_${PN} =+ "gnome-keyring libnotify"

FILES_${PN} += "${datadir}/nm-applet/ \
        ${datadir}/libnm-gtk/wifi.ui \
        ${datadir}/gnome-vpn-properties/ \
        ${datadir}/gnome/autostart/ \
	${datadir}/icons/hicolor/ \
        "

FILES_${PN} += "${libdir}/gnome-bluetooth/plugins/*.so"
FILES_${PN}-dev += "${libdir}/gnome-bluetooth/plugins/libnma.la"
FILES_${PN}-staticdev += "${libdir}/gnome-bluetooth/plugins/libnma.a"
FILES_${PN}-dbg += "${libdir}/gnome-bluetooth/plugins/.debug/"

