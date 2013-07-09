require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

#SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

PR = "r0"

#do_patch() {
#        cd ${WORKDIR}/linux-${PV}
#        patch -p1 <${WORKDIR}/aufs3-kbuild.patch
#        patch -p1 <${WORKDIR}/aufs3-base.patch
#        patch -p1 <${WORKDIR}/aufs3-proc_map.patch
#        patch -p1 <${WORKDIR}/aufs3-standalone.patch
#
#        cp -R ${WORKDIR}/aufs/* ${WORKDIR}/linux-${PV}/
#}

SRC_URI[md5sum] = "fd733de96d7ba51ffd7999b2f7afaf89"
SRC_URI[sha256sum] = "46c54452d3e3d2609c89c3f183b118a1c22a9a26ea2dfb9ca1a505108f26ce7d"

