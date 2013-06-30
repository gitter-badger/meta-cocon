PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#SRC_URI_append_libc-uclibc += "file://add-missing-rpmatch.patch \
#"

