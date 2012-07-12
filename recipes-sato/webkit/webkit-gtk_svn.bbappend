PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://Assertions.cpp \
"

EXTRA_OECONF_append += " \
  --enable-jit=no \
  --enable-javascript-debugger=no \
"

do_compile_prepend() {
        cp ${S}/Assertions.cpp ${S}/Source/JavaScriptCore/wtf
}

