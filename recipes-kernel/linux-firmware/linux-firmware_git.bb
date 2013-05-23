DESCRIPTION = "Firmware files for use with Linux kernel"
SECTION = "kernel"
# Notes:
# This is kind of a mess. Each bit of firmware has their own license. Some free
# some not. Leaving this as Proprietary for now, but this recipe should be probably
# be rethought out a bit more around how it deals with licenses.

LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc \
                    file://LICENCE.agere;md5=af0133de6b4a9b2522defd5f188afd31 \
                    file://LICENCE.iwlwifi_firmware;md5=11545778abf78c43d7644d4f171ea1c7 \
		    file://LICENCE.Marvell;md5=9ddea1734a4baf3c78d845151f42a37a \
                    file://LICENCE.ralink-firmware.txt;md5=ab2c269277c45476fb449673911a2dfd \
                    file://LICENCE.rtlwifi_firmware.txt;md5=00d06cfd3eddd5a2698948ead2ad54a5 \
		    file://LICENCE.via_vt6656;md5=e4159694cba42d4377a912e78a6e850f \
                   "
# v5
# SRCREV = "ac879fea73d2b81442029928693329673a854cba"
# v6
SRCREV = "4c79292308ead42fc786c8e189921196ccc298ff"

PV = "0.0+git${SRCPV}"
PR = "r0"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/firmware/linux-firmware.git;protocol=git"

S = "${WORKDIR}/git"

inherit allarch

do_compile() {
	:
}

do_install() {
	install -d  ${D}/lib/firmware/
	cp -r * ${D}/lib/firmware/

	# Libertas sd8686
	ln -sf libertas/sd8686_v9.bin ${D}/lib/firmware/sd8686.bin
	ln -sf libertas/sd8686_v9_helper.bin ${D}/lib/firmware/sd8686_helper.bin


}

PACKAGES =+ "${PN}-broadcom ${PN}-agere ${PN}-iwlwifi ${PN}-marvell ${PN}-ralink ${PN}-realtek ${PN}-vt6656"

# Broadcom (newer cards)
LICENSE_${PN}-broadcom = "Firmware:LICENCE.broadcom_bcm43xx"
FILES_${PN}-broadcom = " \
  /lib/firmware/brcm/* \
  /lib/firmware/LICENCE.broadcom_bcm43xx \
"

# agere
LICENSE_${PN}-agere = "Firmware:LICENCE.agere"
FILES_${PN}-agere = " \
  /lib/firmware/agere_*_fw.bin \
  /lib/firmware/LICENCE.agere \
"

# iwlwifi (Intel)
LICENSE_${PN}-iwlwifi = "Firmware:LICENCE.iwlwifi_firmware"
FILES_${PN}-iwlwifi = " \
  /lib/firmware/iwlwifi-*.ucode \
  /lib/firmware/LICENCE.iwlwifi_firmware \
"

# Marvell
# TODO: more libertas firmware?
LICENSE_${PN}-marvell = "Firmware:LICENCE.Marvell"
FILES_${PN}-marvell = " \
  /lib/firmware/mwl8k/*.fw \
  /lib/firmware/lbtf_usb.bin \
  /lib/firmware/LICENCE.Marvell \
  /lib/firmware/libertas/sd8686_v9* \
  /lib/firmware/sd8686* \
  /lib/firmware/LICENCE.libertas \
"

# Ralink
LICENSE_${PN}-ralink = "Firmware:LICENCE.ralink-firmware"
FILES_${PN}-ralink = " \
  /lib/firmware/rt*.bin \
  /lib/firmware/LICENSE.ralink-firmware.txt \
"
 
# Realtek
LICENSE_${PN}-realtek = "Firmware:LICENCE.rtlwifi_firmware"
FILES_${PN}-realtek = " \
  /lib/firmware/rtlwifi/* \
  /lib/firmware/RTL8192E/* \
  /lib/firmware/LICENCE.rtlwifi_firmware.txt \
"

# VIA
LICENSE_${PN}-vt6656 = "Firmware:LICENCE.via_vt6656"
FILES_${PN}-vt6656 = " \
  /lib/firmware/vntwusb.fw \
  /lib/firmware/LICENCE.via_vt6656 \  
"

FILES_${PN} += "/lib/firmware/*"

