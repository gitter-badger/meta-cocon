require linux.inc

PV = "3.1.10+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "ac100"

SRCREV = "66a8ee5599effdbbb364b38d48c3f6e3b7bf7a68"

SRC_URI = "\
  git://gitorious.org/~marvin24/ac100/marvin24s-kernel.git;protocol=git;branch=l4t-r16-r2-ac100 \
  git://git.code.sf.net/p/aufs/aufs3-standalone;name=aufs \
"
#  file://defconfig \

SRCREV_aufs = "269a613efab1718fd587c2bfc945d095b57f56e2"

S = "${WORKDIR}/git"

do_configure_prepend() {
        #install ${WORKDIR}/defconfig ${WORKDIR}/linux-${PV}/.config
        cd ${S}
        oe_runmake paz00_defconfig
}

