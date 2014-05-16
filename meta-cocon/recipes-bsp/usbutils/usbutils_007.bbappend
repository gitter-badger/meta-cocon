PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "libiconv"

do_compile_prepend() {
        sed -i \
                -e s:'LDFLAGS = ':'LDFLAGS = -liconv ':g \
                ${S}/Makefile
}

