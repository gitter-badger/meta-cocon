DESCRIPTION = "library for easy implementation of a RDP/VNC server"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "zlib libjpeg-turbo libgcrypt libgcrypt-native gnutls gnutls-native"
PR = "r1"

#DEFAULT_PREFERENCE = "-1"


SRC_URI = "git://libvncserver.git.sourceforge.net/gitroot/libvncserver/libvncserver;protocol=git;branch=master \
	   file://acinclude.m4 \
	   file://ignore_webclients.patch \
           file://no_x11vnc_subdir.patch \
" 

# SRCREV = "af614dea112593f3a01e5c75274cd5912d93bf90"
SRCREV = "7bac05aeeda213fda66692ae3296371815d4c91c"

S = "${WORKDIR}/git"
#S = "${WORKDIR}/LibVNCServer-${PV}"


#EXTRA_OEMAKE_append=" SUBDIRS='libvncclient' "


EXTRA_OECONF += " --without-x11vnc --disable-libtool-lock --without-websockets "

inherit cmake


do_configure() {
        # I need only some built-in m4, except libtool and gcrypt...
	cp ${WORKDIR}/acinclude.m4 acinclude.m4
	libtoolize --force
	${CACHED_CONFIGUREVARS} ./autogen.sh ${CONFIGUREOPTS} ${EXTRA_OECONF}
}

do_install_append() {
        install -m 0755 ${WORKDIR}/git/client_examples/.libs/gtkvncviewer ${D}${bindir}/gtkvncviewer
        install -m 0755 ${WORKDIR}/git/client_examples/.libs/SDLvncviewer ${D}${bindir}/SDLvncviewer
}

LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f"

PACKAGES += " \
  ${PN}-server \
"

FILES_${PN} = "\
  ${bindir}/gtkvncviewer \
  ${bindir}/SDLvncviewer \
  ${libdir}/libvncclient.so.* \
"

FILES_${PN}-server = "\
  ${bindir}/linuxvnc \
  ${libdir}/libvncserver.so.* \
"

FILES_${PN}-dev = "\
  ${bindir}/libvncserver-config \
  ${includedir}/rfb/* \
  ${libdir}/libvncclient.la \
  ${libdir}/libvncserver.la \
  ${libdir}/pkgconfig/* \
  ${libdir}/libvnc*.so \
"


