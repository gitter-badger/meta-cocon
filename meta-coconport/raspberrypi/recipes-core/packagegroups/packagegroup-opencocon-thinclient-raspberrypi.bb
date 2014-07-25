# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Task for opencocon thinclient on Raspberry Pi (without X.org)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup


RDEPENDS_${PN} = " \
base-files \
base-passwd \
busybox \
cocon-data-doc \
dropbear \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
gnutls \
gnutls-openssl \
kbd \
kbd-keymaps \
kernel-modules \
keymaps \
libgcc \
libgcrypt \
libgpg-error \
linux-firmware-ralink \
linux-firmware-rtl8192cu \
linux-firmware-rtl8192su \
linux-firmware-sd8686 \
linux-firmware-sd8787 \
linux-firmware-sd8797 \
linux-firmware-usb8388 \
linux-firmware-usb8388-thinfirm \
linux-firmware-vt6656 \
openssl \
opkg \
uclibc \
udev \
update-rc.d \
usbutils \
userland \
util-linux-cfdisk \
util-linux-fdisk \
wireless-tools \
wpa-supplicant \
zd1211-firmware \
"

