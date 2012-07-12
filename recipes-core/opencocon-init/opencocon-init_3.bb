DESCRIPTION = "opencocon init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox"
PR = "r8"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
	   file://need \
           file://provide \
           file://inittab \
           file://rcS-default \
           file://rc \
           file://rcS \
           file://setup.sh \
           file://menu.sh \
           file://key.conf \
           file://gplv2.txt \
           file://gplv3.txt \
           file://lgpl-2.1.txt \
           file://lgplv3.txt \
           file://about.txt \
	   file://xcocon.sh \
	   file://udev-cocon \
	   file://panel \
"


S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${sysconfdir}
        install -d ${D}${sysconfdir}/default
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d
        install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
        install -m 0644    ${WORKDIR}/rcS-default       ${D}${sysconfdir}/default/rcS  
        install -m 0755    ${WORKDIR}/rc                ${D}${sysconfdir}/init.d
        install -m 0755    ${WORKDIR}/rcS               ${D}${sysconfdir}/init.d


        install -d ${D}${base_sbindir}/
        install -m 0755    ${WORKDIR}/setup.sh          ${D}${base_sbindir}/setup.sh

        install -d ${D}${base_bindir}/
        install -m 0755    ${WORKDIR}/menu.sh          ${D}${base_bindir}/menu.sh
	install -d ${D}/home/root/
	install -m 0755 ${WORKDIR}/xcocon.sh ${D}/home/root/.xinitrc

	# TODO : need to sepalate package (udev init)
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/udev-cocon ${D}${sysconfdir}/init.d/udev-cocon

	# TODO : to global settings...
	install -d ${D}/home/root/.config/lxpanel/default/panels
	install -m 0644 ${WORKDIR}/panel ${D}/home/root/.config/lxpanel/default/panels/panel

        install -d ${D}${datadir}/doc/cocon/
        install -m 0644 ${WORKDIR}/about.txt ${D}${datadir}/doc/cocon/about.txt
        install -m 0644 ${WORKDIR}/gplv2.txt ${D}${datadir}/doc/cocon/gplv2.txt
        install -m 0644 ${WORKDIR}/gplv3.txt ${D}${datadir}/doc/cocon/gplv3.txt
        install -m 0644 ${WORKDIR}/lgpl-2.1.txt ${D}${datadir}/doc/cocon/lgpl-2.1.txt
        install -m 0644 ${WORKDIR}/lgplv3.txt ${D}${datadir}/doc/cocon/lgplv3.txt
	install -m 0644 ${WORKDIR}/COPYING.MIT ${D}${datadir}/doc/cocon/COPYING.MIT
}


FILES_${PN} = "/"

