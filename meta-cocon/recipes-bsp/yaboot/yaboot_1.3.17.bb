SUMMARY = "PPC Bootloaer"
HOMEPAGE = "http://yaboot.ozlabs.org/"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PR = "r7"

SRC_URI = "http://yaboot.ozlabs.org/releases/yaboot-${PV}.tar.gz; \
           file://chrpfix.patch;apply=no \
           file://sysfs-ofpath.patch;apply=no \
           file://yaboot-stubfuncs.patch;apply=no \
           file://new-ofpath \
           file://yaboot-1.3.17-nopiessp-gcc4.patch;apply=no \
           file://yabootconfig-1.3.13.patch;apply=no "

#inherit autotools

COMPATIBLE_HOST = "powerpc.*-linux.*"
EXTRA_OEMAKE += "CROSS=${TARGET_PREFIX} PREFIX=${PREFIX}"
S = "${WORKDIR}/yaboot-${PV}"

SRC_URI[md5sum] = "f599f52d1887a86fd798252d2946f635"
SRC_URI[sha256sum] = "2fb738d8fd48b94ab2534a4fdf63738ad02c1a30f4b2add91f837baff8fa2aa1"


do_patch() {
        cd ${S}
        patch -p1 < ${WORKDIR}/yabootconfig-1.3.13.patch
        patch -p0 < ${WORKDIR}/chrpfix.patch
        patch -p1 < ${WORKDIR}/yaboot-1.3.17-nopiessp-gcc4.patch

        sed -i -e "/\(strip \)/d" \
            -e 's/-o root -g root//' \
            -e 's/-Werror//' \
            -e 's:util\/addnote second\/yaboot\.chrp::' \
            -e 's:-I\/usr\/include:${STAGING_INCLUDEDIR}:' \
            ${S}/Makefile

        patch -p0 < ${WORKDIR}/yaboot-stubfuncs.patch
        patch -p0 < ${WORKDIR}/sysfs-ofpath.patch

        cp ${WORKDIR}/new-ofpath ${S}/ybin/ofpath
}
 

do_install() {
        oe_runmake ROOT="${D}" PREFIX="/usr" MANDIR="share/man" install
}
 
# FILES_${PN} += "/usr//*"
