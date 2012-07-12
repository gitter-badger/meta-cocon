DESCRIPTION = "library for easy implementation of a RDP/VNC server"
AUTHOR = "Johannes Schindelin <dscho@users.sourceforge.net"
HOMEPAGE = "http://sourceforge.net/projects/libvncserver/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "zlib libjpeg-turbo libgcrypt"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/LibVNCServer-${PV}.tar.gz \
	file://autoreconf.patch;patch=1 \
	file://configure_ac.patch;patch=1 \
"
#	file://format_string.patch \
#	file://ignore_webclients.patch \
#	file://no_x11vnc_subdir.patch \
#"

# git://git.debian.org/collab-maint/libvncserver.git;protocol=git;branch= 

#SRCREV = "7f232da1c8a41197321e1e578001f273b79a7577"

#S = "${WORKDIR}/git"
S = "${WORKDIR}/LibVNCServer-${PV}"


#EXTRA_OEMAKE_append=" SUBDIRS='libvncclient' "


EXTRA_OECONF += " --without-x11vnc --disable-libtool-lock  "

inherit autotools


do_configure() {
#	libtoolize --force --recursive
#	aclocal -I .
#	autoheader
#	# try either one of these
#	# automake --add-missing --copy --foreign
#	automake -a --force --copy --foreign        

	oe_runconf
}

#do_compile() {
#	make
#}

LIC_FILES_CHKSUM = "file://COPYING;md5=361b6b837cad26c6900a926b62aada5f"

