DESCRIPTION = "VNC viewer widget for GTK"
HOMEPAGE = "VNC viewer widget for GTK"
AUTHOR = ""
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "openssl virtual/libx11 atk gtk+ cyrus-sasl gnutls libgcrypt jpeg zlib"

PR = "r0"

SRC_URI = "http://ftp.acc.umu.se/pub/GNOME/sources/gtk-vnc/0.5/gtk-vnc-${PV}.tar.xz \
"

EXTRA_OECONF = " \
  --enable-plugin=no \
  --with-sasl \ 
  --without-python \
  --with-examples \
  --with-libview \
"

inherit autotools

do_configure_prepend() {
        sed -i \
                -e s:'`$PKG_CONFIG --variable defsdir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/defs\":g \
                -e s:'`$PKG_CONFIG --variable=pygtkincludedir pygobject-2.0`':\"${STAGING_INCDIR}/pygtk-2.0\":g \
                -e s:'`$PKG_CONFIG --variable=datadir pygobject-2.0`':\"${STAGING_DATADIR}\":g \
                -e s:'`$PKG_CONFIG --variable codegendir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/codegen\":g \
                -e s:'`$PKG_CONFIG --variable=fixxref pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/xsl/fixxref.py\":g \
                ${S}/configure.ac

	sed -i -e 's:PYTHON_INCLUDES="-I${py_prefix}/include/python${PYTHON_VERSION}":PYTHON_INCLUDES="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g' \
               -e 's:PYTHON_INCLUDES="$PYTHON_INCLUDES -I${py_exec_prefix}/include/python${PYTHON_VERSION}":PYTHON_INCLUDES="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g' \
	${S}/acinclude.m4
}


SRC_URI[md5sum] = "f45c9649c915af335cff91268e74ab67"
SRC_URI[sha256sum] = "1de65d8ffa8c25a61a8e8c4b7e5963d4a826f4fcf7120d66ed027f5f70cc8f81"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4339efb5fd592e45b9e2641de9fe734f"
