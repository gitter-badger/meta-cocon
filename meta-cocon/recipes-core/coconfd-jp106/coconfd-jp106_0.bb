DESCRIPTION = "opencocon floppy init - VERY ADHOC jp106 keymap pickup"
SECTION = "base"
LICENSE = "GPLv2+"
DEPENDS = "base-files"
RDEPENDS_${PN} = "busybox"
PR = "r1"
LIC_FILES_CHKSUM = "file://generic_GPLv2;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://generic_GPLv2 \
	   file://kbd-jp106-mini.tar.gz \
	   "

# This just makes things easier...
S="${WORKDIR}"

do_install() {
	set -ex

	cd ${WORKDIR}/kbd-mini-cocon

        install -d ${D}/usr/share/keymaps/i386/qwerty
	install -m 0644 jp106.map.gz ${D}/usr/share/keymaps/i386/qwerty/jp106.map.gz

	install -d ${D}/usr/share/keymaps/i386/include/
	install -m 0644 qwerty-layout.inc ${D}/usr/share/keymaps/i386/include/qwerty-layout.inc
	install -m 0644 compose.inc ${D}/usr/share/keymaps/i386/include/compose.inc
        install -m 0644 linux-keys-bare.inc ${D}/usr/share/keymaps/i386/include/linux-keys-bare.inc
        install -m 0644 linux-with-two-alt-keys.inc ${D}/usr/share/keymaps/i386/include/linux-with-two-alt-keys.inc
}


FILES_${PN} = "/"

