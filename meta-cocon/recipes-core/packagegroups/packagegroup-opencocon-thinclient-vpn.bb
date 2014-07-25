# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon VPN extention"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

RDEPENDS_${PN} = " \
networkmanager-openswan \
networkmanager-openvpn \
networkmanager-pptp \
openssh-ssh \
openswan \
openvpn \
pptp-linux \
softether-hamcore \
softether-vpnclient \
softether-vpncmd \
"

