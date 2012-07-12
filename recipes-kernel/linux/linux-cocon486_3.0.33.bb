inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r0"
LINUX_VERSION ?= "3.0.33"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
#DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE_cocon486 = "1"

SRC_URI = "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
        file://aufs3-base.patch;apply=no \
        file://aufs3-standalone.patch;apply=no \
        file://aufs3-kbuild.patch;apply=no \
        file://aufs3-proc_map.patch;apply=no \
        ftp://get.opencocon.org/opencocon/sources-supply/aufs-snapshot_${PV}.tar.gz;name=aufs \
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

SRC_URI[kernel.md5sum] = "2dd825ac1f95bf964e750f3073c18aed"
SRC_URI[kernel.sha256sum] = "b65cc57df70be6d6ec91626011638c208b6fae3ae436819d17ab9011f6b45b61"

SRC_URI[aufs.md5sum] = "2eab223586210c1c675909ca2620396b"
SRC_URI[aufs.sha256sum] = "7dce12f05cd40623e2141f64a563a0e2b30fa4754f328270955f3ab57c54a1c9"

