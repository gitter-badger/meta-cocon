
PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://connman-libresolv-uclibc.patch \
                   file://connman-uclibc-backtrace.patch \
"



