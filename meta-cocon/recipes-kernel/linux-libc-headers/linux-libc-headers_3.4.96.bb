require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

#SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

KORG_ARCHIVE_COMPRESSION = "xz"

#do_patch() {
#        cd ${WORKDIR}/linux-${PV}
#        patch -p1 <${WORKDIR}/aufs3-kbuild.patch
#        patch -p1 <${WORKDIR}/aufs3-base.patch
#        patch -p1 <${WORKDIR}/aufs3-proc_map.patch
#        patch -p1 <${WORKDIR}/aufs3-standalone.patch
#
#        cp -R ${WORKDIR}/aufs/* ${WORKDIR}/linux-${PV}/
#}

SRC_URI[md5sum] = "5e133d894ddd6716f1d538945cbdf296"
SRC_URI[sha256sum] = "cb698a13b8f3b9727852dc839e64a9ea8d9b82615e0b66e3bae303b2b13c6a76"

