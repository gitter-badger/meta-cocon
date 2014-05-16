PRINC := "${@int(PRINC) + 2}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += " --enable-xephyr --enable-kdrive --enable-install-setuid"

LIB_DEPS += "libx11 libxv"
