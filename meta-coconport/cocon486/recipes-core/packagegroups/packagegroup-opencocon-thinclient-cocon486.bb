# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient on cocon486 machine (without X.org)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

COMPATIBLE_MACHINE = "cocon486"

RDEPENDS_${PN} = " \
b43-fwcutter \
base-files \
base-passwd \
busybox \
cocon-data-doc \
dmidecode \
dropbear \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
gnutls \
gnutls-openssl \
grub-legacy \
kbd \
kbd-keymaps \
kernel-firmware-3ccfem556 \
kernel-firmware-3cxem556 \
kernel-firmware-bnx2-mips-06-6.2.1 \
kernel-firmware-bnx2-mips-09-6.2.1a \
kernel-firmware-bnx2-rv2p-06-6.0.15 \
kernel-firmware-bnx2-rv2p-09-6.0.17 \
kernel-firmware-bnx2-rv2p-09ax-6.0.17 \
kernel-firmware-d101m-ucode \
kernel-firmware-d101s-ucode \
kernel-firmware-d102e-ucode \
kernel-firmware-dp83903 \
kernel-firmware-ds1-ctrl \
kernel-firmware-ds1-dsp \
kernel-firmware-ds1e-ctrl \
kernel-firmware-g200-warp \
kernel-firmware-g400-warp \
kernel-firmware-la-pcm \
kernel-firmware-maestro3-assp-kernel \
kernel-firmware-maestro3-assp-minisrc \
kernel-firmware-ne2k \
kernel-firmware-new-code \
kernel-firmware-new-code-fix \
kernel-firmware-pcmlm28 \
kernel-firmware-pe-200 \
kernel-firmware-pe520 \
kernel-firmware-tamarack \
kernel-firmware-tg1 \
kernel-firmware-tg2 \
kernel-firmware-tg3 \
kernel-firmware-tg3-tso \
kernel-firmware-tg3-tso5 \
kernel-firmware-trigger-code \
kernel-firmware-trigger-code-fix \
kernel-firmware-typhoon \
kernel-firmware-xilinx7od \
kernel-firmware-yss225-registers \
kernel-modules \
keymaps \
libgcc \
libgcrypt \
libgpg-error \
linux-firmware-ar3k \
linux-firmware-ar9170 \
linux-firmware-ath6k \
linux-firmware-ath9k \
linux-firmware-bcm4329 \
linux-firmware-bcm4330 \
linux-firmware-bcm4334 \
linux-firmware-iwlegacy-3945-2 \
linux-firmware-iwlegacy-4965-2 \
linux-firmware-iwlwifi-100-5 \
linux-firmware-iwlwifi-1000-5 \
linux-firmware-iwlwifi-105-6 \
linux-firmware-iwlwifi-135-6 \
linux-firmware-iwlwifi-2000-6 \
linux-firmware-iwlwifi-2030-6 \
linux-firmware-iwlwifi-3160-7 \
linux-firmware-iwlwifi-5000-5 \
linux-firmware-iwlwifi-5150-2 \
linux-firmware-iwlwifi-6000-4 \
linux-firmware-iwlwifi-6000g2a-5 \
linux-firmware-iwlwifi-6000g2a-6 \
linux-firmware-iwlwifi-6000g2b-6 \
linux-firmware-iwlwifi-6050-5 \
linux-firmware-iwlwifi-7260-7 \
linux-firmware-mwl8366 \
linux-firmware-mwl8687 \
linux-firmware-orinoco \
linux-firmware-pcie8797 \
linux-firmware-pcie8897 \
linux-firmware-radeon \
linux-firmware-ralink \
linux-firmware-rtl-nic \
linux-firmware-rtl8192ce \
linux-firmware-rtl8192cu \
linux-firmware-rtl8192de \
linux-firmware-rtl8192e \
linux-firmware-rtl8192se \
linux-firmware-rtl8192su \
linux-firmware-rtl8723ae \
linux-firmware-sd8686 \
linux-firmware-sd8787 \
linux-firmware-sd8797 \
linux-firmware-usb8388 \
linux-firmware-usb8388-thinfirm \
linux-firmware-vt6656 \
openssl \
opkg \
pcmciautils \
uclibc \
udev \
update-rc.d \
usbutils \
util-linux-cfdisk \
util-linux-fdisk \
v86d \
wireless-tools \
wpa-supplicant \
zd1211-firmware \
"

