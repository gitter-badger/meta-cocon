SECTION = "libs"
DESCRIPTION = "The SSH library is a C library to authenticate in a \
simple manner to one or more SSH servers. The goal of this project \
is to provide a library much simpler to use than OpenSSHs one. It \
includes SFTP support, and a sample SSH client is provided."
DEPENDS = "openssl"
LICENSE = "LGPL"


SRC_URI = "http://www.libssh.org/files/0.5/libssh-${PV}.tar.gz \
	   file://libssh-0.5.2-examples-link-pthread.patch \
	   file://libssh-0.5.2-uclibc-argp.patch \
"

inherit cmake

OECMAKE_BUILDPATH = "${WORKDIR}/git"
OECMAKE_SOURCEPATH = "${S}"

#EXTRA_OEMAKE += "-DCMAKE_HAVE_PTHREAD_H=OFF"

#do_install () {
#	set -x
#	install -d ${STAGING_INCDIR}/libssh
#	for i in crypto.h libssh.h sftp.h ssh2.h; do
#		install -m 0644 ${S}/include/libssh/$i ${STAGING_INCDIR}/libssh/
#	done
#	oe_libinstall -so -C libssh libssh ${STAGING_LIBDIR}
#}

#do_install () {
#	oe_runmake "prefix=${D}${prefix}" \
#		   "exec_prefix=${D}${exec_prefix}" \
#		   "bindir=${D}${bindir}" \
#		   "incldir=${D}${includedir}" \
#		   "infodir=${D}${infodir}" \
#		   "mandir=${D}${mandir}/man1" \
#		   "libdir=${D}${libdir}" \
#		   install
#}

LIC_FILES_CHKSUM = "file://COPYING;md5=388a4fb1dea8ceae0be78ba9b01fc139"

SRC_URI[md5sum] = "38b67c48af7a9204660a3e08f97ceba6"
SRC_URI[sha256sum] = "41e8b9c1af077544625e8b398582f101dacc3b8457fee1811a724ca4245ab227"

