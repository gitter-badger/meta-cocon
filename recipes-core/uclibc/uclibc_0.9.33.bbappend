PRINC := "${@int(PRINC) + 1}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://uClibc-0.9.33.2-pt-initfini.s-depends-on-uClibc_locale_data.h.patch \
"

