
PRINC := "${@int(PRINC) + 2}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://fix-cipher-des-ede3-cfb1.patch \
"
EXTRA_OECONF_coconppc = "no-asm"
CFLAG_coconppc := "${@'${CFLAG}'.replace('-O2', '')}"


