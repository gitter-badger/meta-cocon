DESCRIPTION = "VL Gothic Japanese TrueType fonts"
HOMEPAGE = "http://sourceforge.jp/projects/efont/"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RDEPENDS_${PN} = "fontconfig-utils"
PR = "r6"

inherit allarch fontcache

SRC_URI = "http://osdn.dl.sourceforge.jp/vlgothic/56168/VLGothic-20120610.tar.bz2"
S = "${WORKDIR}/VLGothic"


do_install () {
        install -d ${D}${datadir}/fonts/ttf/
        for i in *.ttf; do
                install -m 0644 $i ${D}${prefix}/share/fonts/ttf/${i}
        done

        install -d ${D}${sysconfdir}/fonts/conf.d/
#        install -m 0644 ${WORKDIR}/30-liberation-aliases.conf ${D}${sysconfdir}/fonts/conf.d/

        install -d ${D}${prefix}/share/doc/${PN}/
        install -m 0644 LICENSE.en ${D}${datadir}/doc/${PN}/
}

pkg_postinst_${PN} () {
#!/bin/sh
fc-cache
}


PACKAGES = "${PN}"
FILES_${PN} += "${sysconfdir} ${datadir}"

SRC_URI[md5sum] = "1d1c9023a5de9f3c9eea65f28afdfe0e"
SRC_URI[sha256sum] = "9f39bdd0e3627f99ee39263cd716a73d30864777e791a6d02182c64c178e166a"

LIC_FILES_CHKSUM = "file://LICENSE.en;md5=66ecd0fd7e4da6246fa30317c7b66755"
