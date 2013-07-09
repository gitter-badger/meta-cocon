require recipes-graphics/xorg-xserver/xserver-xorg.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=74df27b6254cc88d2799b5f4f5949c00"

# Misc build failure for master HEAD
SRC_URI += "file://crosscompile.patch \
            file://fix_open_max_preprocessor_error.patch \
            file://mips64-compiler.patch \
            file://xserver_xorg-server-02-cve-2013-1940.patch \
           "
SRC_URI[md5sum] = "f87d830aa69885275e26dd6327d76a44"
SRC_URI[sha256sum] = "8ac07c35306ba3fb3c0972722dd4e919303039eca1d40ac7862560e0b2c94cf7"

PR = "${INC_PR}.0"

EXTRA_OECONF += " --enable-xephyr --enable-kdrive --enable-install-setuid"

LIB_DEPS += "libx11 libxv"

