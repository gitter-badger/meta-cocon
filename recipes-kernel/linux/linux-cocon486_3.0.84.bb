inherit kernel
require recipes-kernel/linux/linux.inc

PR = "r0"
LINUX_VERSION ?= "3.0.84"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
#DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE_cocon486 = "1"

SRC_URI = "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
           git://aufs.git.sourceforge.net/gitroot/aufs/aufs3-standalone.git;name=aufs \
           file://defconfig \
"

SRCREV_aufs = "aa3d7447003abd5e3c437de52d8da2e6203390ac"

COMPATIBLE_MACHINE = "cocon486"

do_configure_prepend() {
        install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
        cd ${WORKDIR}/linux-${PV}
        oe_runmake oldconfig
}


# apply patches without quilt
do_patch() {
        cd ${WORKDIR}/linux-${PV}
        patch -p1 <${WORKDIR}/git/aufs3-kbuild.patch
        patch -p1 <${WORKDIR}/git/aufs3-base.patch
        patch -p1 <${WORKDIR}/git/aufs3-proc_map.patch
        patch -p1 <${WORKDIR}/git/aufs3-standalone.patch

        cp -R ${WORKDIR}/git/fs/* ./fs/
        cp -R ${WORKDIR}/git/include/linux/aufs_type.h ./include/linux/

#        patch -p1 <${WORKDIR}/i82365-work-fix.patch
}


