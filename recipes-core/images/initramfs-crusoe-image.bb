# initramfs image with interactive boot menu allowing to select rootfs location
# from choices of block devices, loopback images and NFS.

LICENSE = "MIT"

IMAGE_NAME = "${DISTRO_NAME}-${DISTRO_VERSION}-${MACHINE}-crusoe-initramfs"

IMAGE_INSTALL = " \
busybox \
uclibc \
initramfs-uniboot \
initramfs-module-bootmenu-crusoe \
udev \
udev-utils \
kernel-module-aufs \
kernel-module-loop \
kernel-module-squashfs \
pcmciautils \
kernel-module-usb-storage \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
kernel-module-ehci-hcd \
kernel-module-usbcore \
kernel-module-nls-iso8859-1 \
kernel-module-pcmcia \
kernel-module-i82092 \
kernel-module-i82365 \
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

IMAGE_FSTYPES += " cpio.gz ext2.gz "

inherit image
