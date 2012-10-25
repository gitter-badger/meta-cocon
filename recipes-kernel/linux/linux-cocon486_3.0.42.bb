inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r11"
LINUX_VERSION ?= "3.0.42"

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

SRC_URI[kernel.md5sum] = "c660665aa3cd446eedab89ee6a3a0263"
SRC_URI[kernel.sha256sum] = "61151474d9f2b6d913cee476205d036c7eceaa2860f25be763435784cbbb441c"

SRC_URI[aufs.md5sum] = "248a5ddc371e5129a865532a044d7826"
SRC_URI[aufs.sha256sum] = "e7d36535a6fd380ceee9bf945699bfaf1f9ea065f5ab318dfdc0e9e47bd92723"

