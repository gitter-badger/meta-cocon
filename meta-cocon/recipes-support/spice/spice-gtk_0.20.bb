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

SRC_URI[md5sum] = "9ef6b7f2f368b7966029b7834b7c2bec"
SRC_URI[sha256sum] = "b1355823b0ceb2e118c1f9a9a602ccab78e1e2edf2d93f71fa42d3bc85ca75df"

