DESCRIPTION = "Opengalax Touchpad daemon"
HOMEPAGE = "https://github.com/poliva/opengalax"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbbd794e2a0a289b9dfcc9f513d1996e"

SRC_URI = "git://github.com/poliva/opengalax.git \
"

SRCREV = "13375c67c59ee41e85c2e12bba7de8ceb858176b"

S = "${WORKDIR}/git"


EXTRA_OEMAKE += "'PREFIX=${D}${prefix} CC=${CC} -fomit-frame-pointer \
                  ${CFLAGS}'"


do_compile() {
	sed -i \
                -e s:'/* psmouse */ 0':'/* psmouse */ 1':g \
		${S}/configfile.c

        oe_runmake 
}

do_install() {
        sed -i \
                -e s:'prefix = $(DESTDIR)':'prefix = ${D}':g \
                ${S}/Makefile


        ${MAKE} install

	install -d ${D}${datadir}/spmachine-486/
        install -m 0644 ${S}/10-opengalax.conf ${D}${datadir}/spmachine-486/opengalax.conf

}

FILES_${PN} += "/usr/share/spmachine-486/"
