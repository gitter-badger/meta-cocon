DESCRIPTION = "opencocon floppy init"
SECTION = "base"
LICENSE = "MIT"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox"
PR = "r2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://init \
	   file://usb \
	   file://mdev.conf \
	   file://mdev_path \
	   file://COPYING.MIT \
	   "

# This just makes things easier...
S="${WORKDIR}"

do_install() {
	set -ex
	install -d ${D}/etc
	install -m 0644 mdev.conf ${D}/etc/mdev.conf
	install -m 0755 init ${D}/init
	install -m 0755 usb ${D}/usb
	install -m 0644 mdev_path ${D}/mdev_path
}


FILES_${PN} = "/"

