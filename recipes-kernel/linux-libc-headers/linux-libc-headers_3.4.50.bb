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

SRC_URI[md5sum] = "213239d08746a22a76a84c5e4f09f4bb"
SRC_URI[sha256sum] = "7376e87f9a44b3c37d2ee02e5d731e843e12d35a4d00c6d3761bb1a26c9a7167"

