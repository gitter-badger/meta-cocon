DESCRIPTION = "Ayatana dbus indicator helper library"
LICENSE = "GPLv3"
SECTION = "x11/gnome"
DEPENDS = "dbus gtk+"
PR = "r2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6a6a8e020838b23406c81b19c1d46df6"
EXTRA_OECONF = "--disable-gtk-doc --enable-gtk --disable-tests --with-gtk=2 --enable-introspection=no --disable-vala --disable-gcov --disable-massivedebugging --disable-dumper --disable-silent-rules --disable-valgrind"

inherit autotools
SRC_URI = "http://launchpad.net/dbusmenu/12.10/${PV}/+download/libdbusmenu-${PV}.tar.gz"

do_configure_prepend() {
  # We dont need document.
  sed -i \
    -e s:'GTK_DOC_CHECK':'\# GTK_DOC_CHECK':g \
    ${S}/configure.ac

  sed -i \
    -e s:'GNOME_DOC_INIT':'\# GNOME_DOC_INIT':g \
    ${S}/configure.ac

  sed -i \
    "/.*VALGRIND/d" \
    ${S}/configure.ac

  sed -i \
    -e '1a\\#undef HAVE_VALGRIND' \
    ${S}/config.h.in

  sed -i \
    "/docs\//d" \
    ${S}/configure.ac

  sed -i \
    "/tests\//d" \
    ${S}/configure.ac

  sed -i \
    -e s:'docs \\':'\\':g \
    ${S}/Makefile.am

  sed -i \
    -e s:'TESTS_SUBDIR = tests':'':g \
    ${S}/Makefile.am
}

SRC_URI[md5sum] = "e30fc986b447f62513d61225fa573a70"
SRC_URI[sha256sum] = "9d6ad4a0b918b342ad2ee9230cce8a095eb601cb0cee6ddc1122d0481f9d04c9"

