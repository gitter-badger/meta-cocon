
PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


SRC_URI += "file://defconfig-cocon"


do_configure_append() {
  # Overwrite defconfig
  install -m 0644 ${WORKDIR}/defconfig-cocon ${S}/.config || die "No default configuration for ${MACHINE} / ${KERNEL_DEFCONFIG} available."
}

