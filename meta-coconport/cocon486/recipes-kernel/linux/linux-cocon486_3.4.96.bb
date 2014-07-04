inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.xz;name=kernel \
           git://git.code.sf.net/p/aufs/aufs3-standalone;protocol=http;branch=aufs3.4;name=aufs \
           file://i82365-work-fix.patch;apply=no \
           file://defconfig \
"


SRCREV_aufs = "bfbe10165cbfc0cd7b1d7e9c878f1a3f2b6872f1"

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
        patch -p1 <${WORKDIR}/git/aufs3-mmap.patch
        patch -p1 <${WORKDIR}/git/aufs3-standalone.patch

        cp -R ${WORKDIR}/git/fs/* ./fs/
        cp -R ${WORKDIR}/git/include/linux/aufs_type.h ./include/linux/

        patch -p1 <${WORKDIR}/i82365-work-fix.patch
}
