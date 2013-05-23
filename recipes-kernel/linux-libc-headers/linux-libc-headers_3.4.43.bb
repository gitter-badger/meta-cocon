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

SRC_URI[md5sum] = "5a715fd17a7d706c1715598e62b9c472"
SRC_URI[sha256sum] = "80cf21391e13db743498012377dffbe04abb8237fb5fd3a7a16bbe50aef6ba27"


