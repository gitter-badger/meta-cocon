
PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://webkit-gtk-1.8.3-disable-backtrace-uclibc.patch \
"

#EXTRA_OECONF_append += " \
#  --enable-jit=no \
#  --enable-javascript-debugger=no \
#"


