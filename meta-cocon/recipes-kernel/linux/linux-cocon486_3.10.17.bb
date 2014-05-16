inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r2"

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
           git://git.code.sf.net/p/aufs/aufs3-standalone;name=aufs \
           file://i82365-work-fix-v2.patch \
	   file://platform_driver_probe.patch \
	   file://pd6729.patch \
           file://defconfig \
"

#SRCREV_aufs = "d16ea2b261e21c632cded3214e3c6183a06b9c5f"
SRCREV_aufs = "62f5446c134ac442c690392d841a56f755881ee1"

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
        cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

        patch -p1 <${WORKDIR}/i82365-work-fix-v2.patch
	patch -p1 <${WORKDIR}/pd6729.patch
	patch -p1 <${WORKDIR}/platform_driver_probe.patch
}

