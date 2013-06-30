PR = "r47"
DESCRIPTION = "A modular initramfs init script system."
# RRECOMMENDS_${PN} = "kernel-module-mtdblock"

SRC_URI = "file://init.sh \
file://clean.sh \
file://cocon-init-dummy \
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install() {
        install -m 0755 ${WORKDIR}/init.sh ${D}/linuxrc
	install -m 0755 ${WORKDIR}/clean.sh ${D}/clean
	install -d ${D}${base_bindir}/
	install -m 0755 ${WORKDIR}/cocon-init-dummy ${D}${base_bindir}/cocon-init
}

#PACKAGE_ARCH = "all"
FILES_${PN} += " /linuxrc /clean /bin/cocon-init"
