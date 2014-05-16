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

SRC_URI[md5sum] = "75ce4d56658db99b5ec2ec20b349dbdb"
SRC_URI[sha256sum] = "d8aac289e728ef1020ebbdf0c2b68da3821a65903283ae2c4546f3290fbd7482"

