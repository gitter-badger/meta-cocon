inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r2"
LINUX_VERSION ?= "3.0.52"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
#DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE_cocon486 = "1"

SRC_URI = "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
        file://aufs3-base.patch;apply=no \
        file://aufs3-standalone.patch;apply=no \
        file://aufs3-kbuild.patch;apply=no \
        file://aufs3-proc_map.patch;apply=no \
        ftp://get.opencocon.org/opencocon/sources-supply/aufs-snapshot_3.0.tar.gz;name=aufs \
           file://defconfig \
"

COMPATIBLE_MACHINE = "cocon486"

do_configure_prepend() {
        install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
        cd ${WORKDIR}/linux-${PV}
        oe_runmake oldconfig
}


# apply patches without quilt
do_patch() {
	cd ${WORKDIR}/linux-${PV}
        patch -p1 <${WORKDIR}/aufs3-kbuild.patch
	patch -p1 <${WORKDIR}/aufs3-base.patch
        patch -p1 <${WORKDIR}/aufs3-proc_map.patch
	patch -p1 <${WORKDIR}/aufs3-standalone.patch

	cp -R ${WORKDIR}/aufs/* ${WORKDIR}/linux-${PV}/
}


#PACKAGES += " \
#  kernel-modules-all \
#  kernel-firmwares-all \
#"


#FILES_kernel-modules-all = "\
#  ${base_libdir}/modules/${PV}/* \
#"

#FILES_kernel-firmwares-all = "\
#  ${base_libdir}/firmware/* \
#"


