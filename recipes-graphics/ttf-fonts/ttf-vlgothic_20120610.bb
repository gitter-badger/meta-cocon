require ttf.inc

DESCRIPTION = "VL Gothic Japanese TrueType fonts"
AUTHOR = ""
HOMEPAGE = "http://sourceforge.jp/projects/efont/"
LICENSE = "${PN}"
SRC_DISTRIBUTE_LICENSES += "${PN}"
RPROVIDES_${PN} = "virtual-japanese-font"
PR = "r5"

inherit allarch

SRC_URI = "http://osdn.dl.sourceforge.jp/vlgothic/56168/VLGothic-20120610.tar.bz2"
S = "${WORKDIR}/VLGothic"

FILES_${PN} += "${datadir}/fonts/truetype/VL-Gothic-Regular.ttf \
		      ${datadir}/fonts/truetype/VL-PGothic-Regular.ttf"

do_install_append() {
	# README contains the redistribution license
	install -d ${D}${datadir}/doc/
	install -m 0644 ${S}/LICENSE* ${D}${datadir}/doc
}

SRC_URI[md5sum] = "1d1c9023a5de9f3c9eea65f28afdfe0e"
SRC_URI[sha256sum] = "9f39bdd0e3627f99ee39263cd716a73d30864777e791a6d02182c64c178e166a"

LIC_FILES_CHKSUM = "file://LICENSE.en;md5=66ecd0fd7e4da6246fa30317c7b66755"
