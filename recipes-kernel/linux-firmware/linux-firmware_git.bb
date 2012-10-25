DESCRIPTION = "Firmware files for use with Linux kernel"
SECTION = "kernel"
# Notes:
# This is kind of a mess. Each bit of firmware has their own license. Some free
# some not. Leaving this as Proprietary for now, but this recipe should be probably
# be rethought out a bit more around how it deals with licenses.

LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://LICENCE.agere;md5=af0133de6b4a9b2522defd5f188afd31 \
                    file://LICENCE.iwlwifi_firmware;md5=311cc823df5b1be4f00fbf0f17d96a6b \
		    file://LICENCE.Marvell;md5=9ddea1734a4baf3c78d845151f42a37a \
                    file://LICENCE.ralink-firmware.txt;md5=ab2c269277c45476fb449673911a2dfd \
                    file://LICENCE.rtlwifi_firmware.txt;md5=00d06cfd3eddd5a2698948ead2ad54a5 \
		    file://LICENCE.via_vt6656;md5=e4159694cba42d4377a912e78a6e850f \
                   "

SRCREV = "ac879fea73d2b81442029928693329673a854cba"
PV = "0.0+git${SRCPV}"
PR = "r2"

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
#	ln -sf libertas/sd8686_v9.bin ${D}/lib/firmware/sd8686.bin
#	ln -sf libertas/sd8686_v9_helper.bin ${D}/lib/firmware/sd8686_helper.bin

	# Realtek rtl8192* 
#	install -m 0644 LICENCE.rtlwifi_firmware.txt ${D}/lib/firmware/rtlwifi/LICENCE.rtlwifi_firmware.txt

	# fixup wl12xx location, after 2.6.37 the kernel searches a different location for it
#	( cd ${D}/lib/firmware ; ln -sf ti-connectivity/* . )
}

PACKAGES =+ "${PN}-agere ${PN}-iwlwifi ${PN}-marvell ${PN}-ralink ${PN}-realtek ${PN}-vt6656"


# Libertas
# TODO : not used in cocon yet
#LICENSE_${PN}-sd8686 = "Firmware:LICENSE.libertas"
#FILES_${PN}-sd8686 = " \
#  /lib/firmware/libertas/sd8686_v9* \
#  /lib/firmware/sd8686* \
#  /lib/firmware/LICENCE.libertas \
#"

# agere
LICENSE_${PN}-agere = "Firmware:LICENCE.agere"
FILES_${PN}-agere = " \
  /lib/firmware/agere_ap_fw.bin \
  /lib/firmware/LICENCE.agere \
"

# iwlwifi (Intel)
LICENSE_${PN}-iwlwifi = "Firmware:LICENCE.iwlwifi_firmware"
FILES_${PN}-iwlwifi = " \
  /lib/firmware/iwlwifi-*.ucode \
  /lib/firmware/LICENCE.iwlwifi_firmware \
"

# Marvell
LICENSE_${PN}-marvell = "Firmware:LICENCE.Marvell"
FILES_${PN}-marvell = " \
  /lib/firmware/mwl8k/*.fw \
  /lib/firmware/mwl8335_duplex.fw \
  /lib/firmware/LICENCE.Marvell \
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

