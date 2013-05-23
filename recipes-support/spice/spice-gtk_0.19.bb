LICENSE = "GPLv2"
DEPENDS = "celt cyrus-sasl gtk+ jpeg pulseaudio zlib libusb"
#RDEPENDS= "perl"
PR = "r5"


SRC_URI = "http://spice-space.org/download/gtk/spice-gtk-${PV}.tar.bz2 \
" 

inherit autotools gettext


EXTRA_OECONF += "--without-python --disable-gtk-doc-html --disable-gtk-doc --with-gtk=2.0 --enable-smartcard=no --enable-introspection=no"

do_configure_prepend() {

    sed -i \
        -e s:HAVE_TERMIOS_H:COCON_TERMIOS_DISABLE:g \
        ${S}/gtk/spicy.c

}

CFLAGS += "-fno-stack-protector -O1"

PACKAGES += "${PN}-vala" 
FILES_${PN}-vala += "${datadir}/vala/*"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[md5sum] = "85c1d975ad3c9df4882b91f34b41920d"
SRC_URI[sha256sum] = "43588f68c03d271ea139ec7366db04872c780577bf8a08584d5c2bff001981cf"


