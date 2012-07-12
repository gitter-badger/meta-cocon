require recipes-graphics/xorg-app/xorg-app-common.inc
DESCRIPTION = "xterm is the standard terminal emulator for the X Window System."
DEPENDS = "libxaw xproto xextproto libxext libxau libxpm ncurses"

LIC_FILES_CHKSUM = "file://xterm.h;beginline=3;endline=33;md5=f15ee2e962ca83eefa382c4fe71b4517"

SRC_URI = "ftp://invisible-island.net/xterm/${PN}-${PV}.tgz"
SRC_URI[md5sum] = "bca2eb95bdd57653f8e3f2f57952c1c5"
SRC_URI[sha256sum] = "a777c81736aaca329ef54ef9d0bf5811405986b2afab18417443977f949732fb"

EXTRA_OECONF = " --x-includes=${STAGING_INCDIR} \
                 --x-libraries=${STAGING_LIBDIR} \
                 FREETYPE_CONFIG=${STAGING_BINDIR_CROSS}/freetype-config \
                 --disable-imake \
                 --disable-setuid"

do_configure() {
        sed -e "s%/usr/contrib/X11R6%${STAGING_LIBDIR}%g" -i configure
        oe_runconf
}

FILES_${PN} += " /usr/lib/X11"
