PRINC := "${@int(PRINC) + 2}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += " file://menu.lst \
		    file://grub-0.97-disk_geometry-1.patch \
		    file://grub-support-256byte-inode.diff \
"

#do_compile() {
#    oe_runmake \
#        CFLAGS="-Wall -Os -march=i486 -mtune=native"
#}

do_install_append() {
        install -m 0644 -D ${WORKDIR}/menu.lst ${D}/boot/grub/menu.lst

        # Copy stage1/1_5/2 files to /boot/grub
        GRUB_TARGET_ARCH=$(echo ${TARGET_ARCH} | sed -e 's/.86/386/')

	mkdir -p ${D}/boot/grub
	mkdir -p ${D}/${libdir}/grub/${GRUB_TARGET_ARCH}${TARGET_VENDOR}

        install -m 0644 \
                ${D}/${datadir}/grub/* \
                ${D}/boot/grub/
        install -m 0644 \
		${D}/${datadir}/grub/* \
                ${D}/${libdir}/grub/${GRUB_TARGET_ARCH}${TARGET_VENDOR}/

}


