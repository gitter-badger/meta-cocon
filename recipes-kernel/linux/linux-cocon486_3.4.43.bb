inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r2"
LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
           git://aufs.git.sourceforge.net/gitroot/aufs/aufs3-standalone.git;name=aufs \
	   file://i82365-work-fix.patch \
           file://defconfig \
" 


SRCREV_aufs = "070c75b8e088086687688ce8306cc33bea5c8934"

COMPATIBLE_MACHINE = "cocon486"

do_configure_prepend() {
        install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
        cd ${WORKDIR}/linux-${PV}
        oe_runmake oldconfig
}


# apply patches without quilt
do_patch() {
        # Extract aufs tree to Linux tree

	cd ${WORKDIR}/linux-${PV}
        patch -p1 <${WORKDIR}/git/aufs3-kbuild.patch
	patch -p1 <${WORKDIR}/git/aufs3-base.patch
        patch -p1 <${WORKDIR}/git/aufs3-proc_map.patch
	patch -p1 <${WORKDIR}/git/aufs3-standalone.patch

	cp -R ${WORKDIR}/git/fs/* ./fs/
        cp -R ${WORKDIR}/git/include/linux/aufs_type.h ./include/linux/

}

