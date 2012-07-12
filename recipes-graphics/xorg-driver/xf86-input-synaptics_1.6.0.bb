require recipes-graphics/xorg-driver/xorg-driver-input.inc

DESCRIPTION = "X.Org X server -- mouse input driver"
PE = "1"
PR = "${INC_PR}.1"

EXTRA_OEMAKE += " sdkdir=${STAGING_INCDIR}/xorg "

FILES_${PN} += "/usr/share/X11/xorg.conf.d/50-synaptics.conf"

LIC_FILES_CHKSUM = "file://COPYING;md5=e395e21f3c21d4fc3a243783e85e9ab5"

SRC_URI[md5sum] = "68a1f6b021b5ef7a7178af92ceb33dd2"
SRC_URI[sha256sum] = "89a4b09cd3c5cb05c7627e44d03efcf156c4bcb3c162f50c7963c8b6cb21030a"
