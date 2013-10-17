# From Angstrom tree
# https://gitorious.org/angstrom/openembedded/source/7e5ea0e6826d138349c40ff296e5b86cf46fead7:recipes/openswan/openswan_2.6.31.bb

SECTION = "console/network"
DESCRIPTION = "Openswan is an Open Source implementation of IPsec for the \
Linux operating system."
HOMEPAGE = "http://www.openswan.org"
LICENSE = "GPLv2"
DEPENDS = "gmp flex-native bison-native"
RRECOMMENDS_${PN} = "kernel-module-ipsec"
RDEPENDS_append_nylon = "perl"
PR = "r1"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

SRC_URI = "http://www.openswan.org/download/openswan-${PV}.tar.gz"

EXTRA_OEMAKE = "DESTDIR=${D} \
                USERCOMPILE="${CFLAGS}" \
                USERLINK="${LDFLAGS}" \
                FINALCONFDIR=${sysconfdir}/ipsec \
                FINALLIBDIR=${libdir}/ipsec \
                FINALLIBEXECDIR=${libexecdir}/ipsec \
                FINALSBINDIR=${sbindir} \
                INC_RCDEFAULT=${sysconfdir}/init.d \
                INC_USRLOCAL=${prefix} \
                INC_MANDIR=share/man WERROR=''"

do_compile () {
	oe_runmake programs
}

do_install () {
	oe_runmake install
}

PACKAGES =+ "${PN}-examples ${PN}-test ${PN}-klips"

FILES_${PN} = "${sysconfdir} ${libdir}/ipsec/* ${sbindir}/* ${libexecdir}/ipsec/*"
FILES_${PN}-dbg += "${libdir}/ipsec/.debug ${libexecdir}/ipsec/.debug"

CONFFILES_${PN} = "${sysconfdir}/ipsec/ipsec.conf"

FILES_${PN}-examples = "${sysconfdir}/ipsec.d/examples"

# KLIPS requires some binaries and scripts that NETKEY users don't need.
FILES_${PN}-klips = " \
        ${libexecdir}/ipsec/eroute \
        ${libexecdir}/ipsec/klipsdebug \
        ${libexecdir}/ipsec/spi \
        ${libexecdir}/ipsec/spigrp \
        ${libexecdir}/ipsec/tncfg \
        ${libdir}/ipsec/_updown.klips \
"

FILES_${PN}-test = " \
        ${libexecdir}/ipsec/showpolicy \
        ${libexecdir}/ipsec/verify \
"

SRC_URI[md5sum] = "199757597f9f776d85752bb0c713b5ed"
SRC_URI[sha256sum] = "95c52552465ca3a8a57452ea425bd03347fc17d9f4a14b0b9fbe06dbd5cb013e"

