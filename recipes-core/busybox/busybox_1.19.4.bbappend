PRINC := "${@int(PRINC) + 2}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://linux-headers-fix.patch \
"

