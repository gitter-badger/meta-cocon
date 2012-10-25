# initramfs image with interactive boot menu allowing to select rootfs location
# from choices of block devices, loopback images and NFS.

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_NAME = "${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}-crusoe-initramfs"

IMAGE_INSTALL = " \
base-files \
busybox \
uclibc \
initramfs-uniboot \
initramfs-module-bootmenu-crusoe \
udev \
udev-utils \
pcmciautils \
kernel-module-usb-storage \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
kernel-module-ehci-hcd \
kernel-module-usbcore \
kernel-module-pcmcia \
kernel-module-pd6729 \
kernel-module-tcic \
kernel-module-yenta-socket \
kernel-module-pata-pcmcia \
kernel-module-pata-ninja32 \
"

IMAGE_LINGUAS = ""


# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules module-init-tools-depmod update-rc.d "
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

IMAGE_FSTYPES += " cpio.gz ext2.gz cramfs.gz "
# IMAGE_ROOTFS_SIZE = "8192"

#inherit bootimg 
inherit image
