PRINC := "${@int(PRINC) + 2}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

CMDLINE_raspberrypi = "dwc_otg.lpm_enable=0 root=/dev/mmcblk0p2 rootdelay=1"

