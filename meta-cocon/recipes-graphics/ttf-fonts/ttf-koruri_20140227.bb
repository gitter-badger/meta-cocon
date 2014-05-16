DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "http://koruri.lindwurm.biz/"
LICENSE = "Apache-2.0"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RDEPENDS_${PN} = "fontconfig-utils"
PR = "r0"

inherit allarch fontcache

SRC_URI = "http://osdn.dl.sourceforge.jp/koruri/60670/Koruri-${PV}.tar.xz"
S = "${WORKDIR}/Koruri-${PV}"


do_install () {
        install -d ${D}${datadir}/fonts/ttf/
        for i in *.ttf; do
                install -m 0644 $i ${D}${prefix}/share/fonts/ttf/${i}
        done

#        install -d ${D}${sysconfdir}/fonts/conf.d/
#        install -m 0644 ${WORKDIR}/30-liberation-aliases.conf ${D}${sysconfdir}/fonts/conf.d/

        install -d ${D}${prefix}/share/doc/${PN}/
        install -m 0644 LICENSE.txt ${D}${datadir}/doc/${PN}/
}

pkg_postinst_${PN} () {
#!/bin/sh
fc-cache
}


PACKAGES = "${PN}"
FILES_${PN} += "${sysconfdir} ${datadir}"

SRC_URI[md5sum] = "b34069e6118a19e0360c9462ca8d6843"
SRC_URI[sha256sum] = "167cc90fdfb93a0b74e6e814c85f9ccdabfaf982b7cebf051e39760eb5f9079d"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b3c555e6db1b49c42179e4717f69b607"
