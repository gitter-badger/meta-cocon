# Initramfs image

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

IMAGE_INSTALL = " \
		busybox \
		uclibc \
		coconfd-init \
		coconfd-jp106 \
		kernel-module-fat \
		kernel-module-vfat \
		kernel-module-usbcore \
		kernel-module-uhci-hcd \
		kernel-module-ohci-hcd \
		kernel-module-ehci-hcd \
		kernel-module-usb-storage \
		kernel-module-nls-cp437 \
		kernel-module-nls-iso8859-1 \
		util-linux-cfdisk \
		util-linux-fdisk \
		kbd \
"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "initramfs-coconfd-image"

IMAGE_LINGUAS = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

FEED_DEPLOYDIR_BASE_URI = ""
ONLINE_PACKAGE_MANAGEMENT = "none"

inherit image
