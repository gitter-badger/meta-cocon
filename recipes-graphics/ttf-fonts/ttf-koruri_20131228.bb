DESCRIPTION = "The Koruri - Japanese TrueType fonts"
HOMEPAGE = "http://koruri.lindwurm.biz/"
LICENSE = "Apache-2.0"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RDEPENDS_${PN} = "fontconfig-utils"
PR = "r0"

inherit allarch fontcache

SRC_URI = "http://osdn.dl.sourceforge.jp/koruri/60169/Koruri-${PV}.tar.xz"
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

SRC_URI[md5sum] = "85f5c31ee6279037408451bcd3be31a9"
SRC_URI[sha256sum] = "815c4f53ee63fda58c03b73fe6ed7101fe563477a8ff2e8a48ff8c11a20c8ecb"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b3c555e6db1b49c42179e4717f69b607"
