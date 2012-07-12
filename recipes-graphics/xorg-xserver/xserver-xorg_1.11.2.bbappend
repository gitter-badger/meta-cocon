PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += " --enable-xephyr --enable-kdrive"

LIB_DEPS += "libx11 libxv"
