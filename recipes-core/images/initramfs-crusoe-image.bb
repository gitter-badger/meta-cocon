# initramfs image with interactive boot menu allowing to select rootfs location
# from choices of block devices, loopback images and NFS.

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_NAME = "${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}-crusoe-initramfs"

CRUSOE_BASE_PACKAGE = " \
base-files \
busybox \
uclibc \
initramfs-uniboot \
initramfs-module-bootmenu-crusoe \
udev \
udev-utils \
kernel-module-usb-storage \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
kernel-module-ehci-hcd \
kernel-module-usbcore \
"

CRUSOE_486ONLY_PACKAGE = " \
kernel-module-pata-pcmcia \
kernel-module-pata-ninja32 \
kernel-module-tcic \
kernel-module-pcmcia \
kernel-module-pd6729 \
kernel-module-i82365 \
kernel-module-yenta-socket \
pcmciautils \
"

CRUSOE_PPCONLY_PACKAGE = " \
"

IMAGE_INSTALL_cocon486 = "${CRUSOE_BASE_PACKAGE} ${CRUSOE_486ONLY_PACKAGE}"
IMAGE_INSTALL_coconppc = "${CRUSOE_BASE_PACKAGE} ${CRUSOE_PPCONLY_PACKAGE}"
IMAGE_LINGUAS = ""


# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules module-init-tools-depmod update-rc.d "
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

IMAGE_FSTYPES += "cramfs.gz"

#inherit bootimg 
inherit image
