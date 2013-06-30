require recipes-kernel/linux-libc-headers/linux-libc-headers.inc
#LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

B = "${S}"

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PROVIDES = "linux-libc-headers"
RPROVIDES_${PN}-dev = "linux-libc-headers-dev"
RPROVIDES_${PN}-dbg = "linux-libc-headers-dbg"
KBRANCH ?= "standard/base"
KMETA ?= "meta"
PV = "3.0.63"
PR = "r0"

SRC_URI += "ftp://ftp.riken.jp/pub/Linux/kernel.org/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
        ftp://get.opencocon.org/opencocon/sources-supply/aufs-snapshot_3.0.tar.gz;name=aufs \
	file://linux-3.0.27-headers_install-fix-__packed-in-exported-kernel-head.patch \
"


# force this to empty to prevent installation failures, we aren't
# building a device tree as part of kern headers
KERNEL_DEVICETREE = ""

set_arch() {
	case ${TARGET_ARCH} in
		arm*)     ARCH=arm ;;
		i*86*)    ARCH=i386 ;;
		ia64*)    ARCH=ia64 ;;
		mips*)    ARCH=mips ;;
		powerpc*) ARCH=powerpc ;;
		x86_64*)  ARCH=x86_64 ;;
	esac
}

do_configure() {
	set_arch
	oe_runmake allnoconfig ARCH=$ARCH
}

do_install() {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH

        # The ..install.cmd conflicts between various configure runs
        find ${D}${includedir} -name ..install.cmd | xargs rm -f
}

# The following tasks are not required when we just want
# headers. So we override and stub them out.
do_kernel_configme() {
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

do_compile () {
}

do_validate_branches () {
}

do_kernel_configcheck () {
}

BBCLASSEXTEND = "nativesdk"

SRC_URI[md5sum] = "abaf65516980c909e507cd614f357654"
SRC_URI[sha256sum] = "24e3c779a13d0288bc3a368e308b675e14bc3e8ab22cb4bf21c3fb0fbb35b003"

SRC_URI[aufs.md5sum] = "6b3b8d4e2d53dfe52b675996c864db1c"
SRC_URI[aufs.sha256sum] = "652a8385a487c901896d4fa70deba609dc1b979ea52d67ef68b43316804e1233"
