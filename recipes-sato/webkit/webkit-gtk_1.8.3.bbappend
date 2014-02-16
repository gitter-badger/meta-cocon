
PRINC := "${@int(PRINC) + 3}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://webkit-gtk-1.8.3-disable-backtrace-uclibc.patch \
"

# DEPENDS += " gtk+ "

#EXTRA_OECONF += " \
#  --enable-javascript-debugger=no \
#"

EXTRA_OECONF__raspberrypi += " --enable-jit=no "

LDFLAGS += "-Wl,--no-keep-memory"

