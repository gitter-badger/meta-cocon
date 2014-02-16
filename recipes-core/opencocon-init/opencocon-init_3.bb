DESCRIPTION = "opencocon init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox"
PR = "r133"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://COPYING.MIT \
	   file://COPYING.PICS \
	   file://need \
           file://provide \
           file://inittab \
           file://rcS-default \
           file://rc \
           file://rcS \
           file://setup.sh \
           file://gplv2.txt \
           file://gplv3.txt \
           file://lgpl-2.1.txt \
           file://lgplv3.txt \
           file://about.txt \
	   file://panel \
	   file://gtkrc \
	   file://cocon-caravan-launch \
	   file://cocon-freerdp-launch \
	   file://cocon-init \
	   file://cocon-menu \
	   file://cocon-menu-launch \
	   file://cocon-netset-launch \
	   file://cocon-poweroff \
           file://cocon-spmachine \
	   file://cocon-vnc-launch \
	   file://cocon-xephyr-launch \
	   file://cocon-spice-launch \
	   file://lxterminal.conf \
	   file://midori-config \
	   file://xinitrc \ 
	   file://cocon-startx \
	   file://cocon-option-menu \
	   file://sample1.jpg \
	   file://sample2.jpg \
           file://sample3.jpg \
           file://sample4.jpg \
           file://sample5.jpg \
	   file://card-fbdev.conf \
	   file://defaultdepth.conf \
	   file://spicy-settings \
           file://default.cnf \
           file://geode-1024x600.conf \
           file://geode-800x480.conf \
           file://poulsbo.conf \
           file://smi_712.conf \
           file://libretto-lx.conf \
           file://sony-pcg-c1.conf \
           file://kohjinsha-pm.conf \
           file://cocon-version \
           file://cocon-x-session \
           file://50-org.freedesktop.NetworkManager.rules \
           file://cocon-read-cnf \
"


S="${WORKDIR}"

do_install() {
	set -ex

        install -d ${D}${sysconfdir}
        install -d ${D}${sysconfdir}/default
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d
        install -m 0644 ${WORKDIR}/cocon-version ${D}${sysconfdir}/cocon-version
        install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
        install -m 0644    ${WORKDIR}/rcS-default       ${D}${sysconfdir}/default/rcS  
        install -m 0755    ${WORKDIR}/rc                ${D}${sysconfdir}/init.d
        install -m 0755    ${WORKDIR}/rcS               ${D}${sysconfdir}/init.d


        install -d ${D}${base_sbindir}/
        install -m 0755    ${WORKDIR}/setup.sh          ${D}${base_sbindir}/setup.sh

        install -d ${D}${base_bindir}/
        install -m 0755    ${WORKDIR}/cocon-init          ${D}${base_bindir}/cocon-init

	install -d ${D}${bindir}/
	install -m 0755    ${WORKDIR}/cocon-caravan-launch     ${D}${bindir}/cocon-caravan-launch
	install -m 0755    ${WORKDIR}/cocon-freerdp-launch     ${D}${bindir}/cocon-freerdp-launch
	install -m 0755    ${WORKDIR}/cocon-menu     ${D}${bindir}/cocon-menu
	install -m 0755    ${WORKDIR}/cocon-menu-launch     ${D}${bindir}/cocon-menu-launch
	install -m 0755    ${WORKDIR}/cocon-netset-launch     ${D}${bindir}/cocon-netset-launch
	install -m 0755    ${WORKDIR}/cocon-poweroff     ${D}${bindir}/cocon-poweroff
	install -m 0755    ${WORKDIR}/cocon-vnc-launch     ${D}${bindir}/cocon-vnc-launch
	install -m 0755    ${WORKDIR}/cocon-xephyr-launch     ${D}${bindir}/cocon-xephyr-launch
	install -m 0755    ${WORKDIR}/cocon-startx     ${D}${bindir}/cocon-startx
	install -m 0755    ${WORKDIR}/cocon-option-menu     ${D}${bindir}/cocon-option-menu
        install -m 0755    ${WORKDIR}/cocon-spice-launch    ${D}${bindir}/cocon-spice-launch
        install -m 0755    ${WORKDIR}/cocon-spmachine    ${D}${bindir}/cocon-spmachine
        install -m 0755    ${WORKDIR}/cocon-x-session    ${D}${bindir}/cocon-x-session
        install -m 0755    ${WORKDIR}/cocon-read-cnf    ${D}${bindir}/cocon-read-cnf

	install -d ${D}${sysconfdir}/gtk-2.0
	install -m 0644 ${WORKDIR}/gtkrc ${D}${sysconfdir}/gtk-2.0/gtkrc

	# TODO : to global settings...
	install -d ${D}${sysconfdir}/skel
	install -d ${D}${sysconfdir}/skel/.config/lxpanel/default/panels	
	install -d ${D}${sysconfdir}/skel/.config/lxterminal
	install -d ${D}${sysconfdir}/skel/.config/midori
	install -d ${D}${sysconfdir}/skel/.config/spicy
        install -d ${D}${sysconfdir}/polkit-1/
        install -d ${D}${sysconfdir}/polkit-1/rules.d/
	install -m 0755 ${WORKDIR}/xinitrc ${D}${sysconfdir}/skel/.xinitrc
	install -m 0644 ${WORKDIR}/panel ${D}${sysconfdir}/skel/.config/lxpanel/default/panels/panel
	install -m 0644 ${WORKDIR}/lxterminal.conf ${D}${sysconfdir}/skel/.config/lxterminal/lxterminal.conf
	install -m 0644 ${WORKDIR}/midori-config ${D}${sysconfdir}/skel/.config/midori/config
	install -m 0644 ${WORKDIR}/spicy-settings ${D}${sysconfdir}/skel/.config/spicy/settings
        install -m 0644 ${WORKDIR}/50-org.freedesktop.NetworkManager.rules ${D}${sysconfdir}/polkit-1/rules.d/50-org.freedesktop.NetworkManager.rules
 
        install -d ${D}${datadir}/doc/cocon/
        install -m 0644 ${WORKDIR}/about.txt ${D}${datadir}/doc/cocon/about.txt
        install -m 0644 ${WORKDIR}/gplv2.txt ${D}${datadir}/doc/cocon/gplv2.txt
        install -m 0644 ${WORKDIR}/gplv3.txt ${D}${datadir}/doc/cocon/gplv3.txt
        install -m 0644 ${WORKDIR}/lgpl-2.1.txt ${D}${datadir}/doc/cocon/lgpl-2.1.txt
        install -m 0644 ${WORKDIR}/lgplv3.txt ${D}${datadir}/doc/cocon/lgplv3.txt
	install -m 0644 ${WORKDIR}/COPYING.MIT ${D}${datadir}/doc/cocon/COPYING.MIT
	install -d ${D}${datadir}/cocon/
        install -m 0644 ${WORKDIR}/card-fbdev.conf ${D}${datadir}/cocon/card-fbdev.conf
	install -m 0644 ${WORKDIR}/defaultdepth.conf ${D}${datadir}/cocon/defaultdepth.conf
        install -m 0644 ${WORKDIR}/geode-1024x600.conf ${D}${datadir}/cocon/geode-1024x600.conf
        install -m 0644 ${WORKDIR}/geode-800x480.conf ${D}${datadir}/cocon/geode-800x480.conf
        install -m 0644 ${WORKDIR}/default.cnf ${D}${datadir}/cocon/default.cnf
	install -m 0644 ${WORKDIR}/poulsbo.conf ${D}${datadir}/cocon/poulsbo.conf
        install -m 0644 ${WORKDIR}/smi_712.conf ${D}${datadir}/cocon/smi_712.conf
        install -m 0644 ${WORKDIR}/sony-pcg-c1.conf ${D}${datadir}/cocon/sony-pcg-c1.conf
        install -m 0644 ${WORKDIR}/libretto-lx.conf ${D}${datadir}/cocon/libretto-lx.conf
        install -m 0644 ${WORKDIR}/kohjinsha-pm.conf ${D}${datadir}/cocon/kohjinsha-pm.conf

	install -d ${D}${datadir}/cocon/pic/
        install -m 0644 ${WORKDIR}/COPYING.PICS ${D}${datadir}/cocon/pic/COPYING.PICS
	install -m 0644 ${WORKDIR}/sample1.jpg ${D}${datadir}/cocon/pic/sample1.jpg
        install -m 0644 ${WORKDIR}/sample2.jpg ${D}${datadir}/cocon/pic/sample2.jpg
        install -m 0644 ${WORKDIR}/sample3.jpg ${D}${datadir}/cocon/pic/sample3.jpg
        install -m 0644 ${WORKDIR}/sample4.jpg ${D}${datadir}/cocon/pic/sample4.jpg
        install -m 0644 ${WORKDIR}/sample5.jpg ${D}${datadir}/cocon/pic/sample5.jpg
}


FILES_${PN} = "/"

