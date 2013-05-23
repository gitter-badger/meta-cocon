PRINC := "${@int(PRINC) + 1}"

# look for files in the layer first
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "http://sourceforge.net/projects/cramfs/files/cramfs/1.1/cramfs-${PV}.tar.gz"
