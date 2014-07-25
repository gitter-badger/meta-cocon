PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# opencocon for Raspberrypi don't use eglibc-locale, but bitbake builds this
# recipe, so this bbappend is workaround.


# Do nothing.

do_install() {
    :
}
