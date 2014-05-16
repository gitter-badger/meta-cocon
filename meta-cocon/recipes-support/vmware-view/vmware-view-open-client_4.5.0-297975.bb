LICENSE = "LGPLv2"
#DEPENDS = "celt cyrus-sasl gtk+ jpeg pulseaudio zlib libusb"
#RDEPENDS= "perl"


SRC_URI = "http://vmware-view-open-client.googlecode.com/files/VMware-view-open-client-source-${PV}.tar.gz \
" 
SRC_URI[md5sum] = "c750209ff0dc4043847d4566bb70f9d1"
SRC_URI[sha256sum] = "8c81aed954419180c4b36807df15907b333c5558dd0b57650f3743af7c67702c"

inherit autotools gettext

S = "${WORKDIR}/VMware-view-open-client-source-${PV}"

#EXTRA_OECONF += "--without-python --disable-gtk-doc-html --disable-gtk-doc --with-gtk=2.0 --enable-smartcard=no --enable-introspection=no"

#do_configure_prepend() {
#
#    sed -i \
#        -e s:'gtk-doc.make':'':g \
#        ${S}/Makefile.am
#
#    sed -i \
#        -e s:'gtk-doc.make':'':g \
#        ${S}/doc/reference/Makefile.am
#}

#CFLAGS += "-fno-stack-protector -O1"

#PACKAGES += "${PN}-vala" 
#FILES_${PN}-vala += "${datadir}/vala/*"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"



