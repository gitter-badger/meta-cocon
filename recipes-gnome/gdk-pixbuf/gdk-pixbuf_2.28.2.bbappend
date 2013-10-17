PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

X11DEPENDS = "--with-x11"
X11DEPENDS_cocon486 = "--with-x11"

