inherit kernel
require recipes-kernel/linux/linux.inc

LINUX_VERSION = "${PV}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.xz;name=kernel \
           git://git.code.sf.net/p/aufs/aufs3-standalone;protocol=http;branch=aufs3.10.x;name=aufs \
           file://i82365-work-fix-v2.patch \
	   file://platform_driver_probe.patch \
	   file://pd6729.patch \
           file://defconfig \
"

SRCREV_aufs = "24279ba05aacd107d09e171fffc6881bfd007d8b"

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
        cp -R ${WORKDIR}/git/include/uapi/linux/aufs_type.h ./include/uapi/linux/

        patch -p1 <${WORKDIR}/i82365-work-fix-v2.patch
	patch -p1 <${WORKDIR}/pd6729.patch
	patch -p1 <${WORKDIR}/platform_driver_probe.patch
}

SRC_URI[kernel.md5sum] = "ef927e91cf8b8c4ddf98847341ccf2c8"
SRC_URI[kernel.sha256sum] = "95f9be5a26f6c15d21528ecdb2cd3307fc99c715cfb3bce13843de8393f67028"

