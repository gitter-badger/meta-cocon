require linux.inc

PV = "3.10.23+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "ac100"

SRCREV = "daac5225e4c008849638c3d649fbbd69358684ab"

SRC_URI = "\
  git://gitorious.org/~marvin24/ac100/marvin24s-kernel.git;protocol=git;branch=linux-ac100-3.10 \
"
#  file://defconfig \

#SRCREV_aufs = "269a613efab1718fd587c2bfc945d095b57f56e2"

S = "${WORKDIR}/git"

do_configure_prepend() {
    #install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
    cd ${S}
    oe_runmake tegra_defconfig
}
