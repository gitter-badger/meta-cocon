PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += " ac_cv_tls=no --disable-threads "
