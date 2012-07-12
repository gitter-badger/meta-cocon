PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_libc-uclibc += "file://005-uclibc-0.9.30-compat.patch \
"

