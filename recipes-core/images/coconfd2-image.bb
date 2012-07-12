# This image is intended to provide a basic configuration that allows
# you to access a newly flashed device over the network or via the
# native console, and use ipkg to install (from feeds accessible via
# the network) any further features you require into internal flash
# memory or onto attached storage.

# It should be as small as possible, while still achieving that goal.

# The rationale for naming it 'base-image' is that this image is the
# base upon which you can install any other functionality you desire.

# See the end of this file for further rationale and policy regarding
# the contents of this image, and the criteria which are used to make
# decisions about adding and removing packages from this image.

# Although it is only fully tested with the Angstrom distro, this
# image is intended to be distro-agnostic.


IMAGE_NAME = "opencocon-${DISTRO_VERSION}-${MACHINE}"

#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DISTRO_UPDATE_ALTERNATIVES ?= "${PREFERRED_PROVIDER_virtual/update-alternatives}"

DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"
ONLINE_PACKAGE_MANAGEMENT = "no"

# FIXME: We need a distro-indendent way of specifying feed configs.
# Once the RFC for the DISTRO_FEED_CONFIGS variable name is approved,
# we can remove this default definition and set it in the distro config.
#DISTRO_FEED_CONFIGS ?= "${ANGSTROM_FEED_CONFIGS}"


RDEPENDS = " \
	base-files \
	base-passwd \
	modutils-initscripts \
	keymaps	\
        uclibc \ 
        uclibc-utils \
        busybox \
        opkg \
	libgcc \
	grub \
	xserver-xorg \
	dialog \
	xf86-input-evdev \
	xf86-video-fbdev \
	xf86-video-intel \
	xterm \
	xauth \
	encodings \
	font-util \
	xorg-minimal-fonts \
	xinit \
	pcmciautils \
	usbutils \
	wireless-tools \
	wpa-supplicant \
	dbus-x11 \
	update-rc.d \
"

IMAGE_INSTALL = " \
        base-files \
        base-passwd \
        modutils-initscripts \
        keymaps \
        uclibc \
        uclibc-utils \
        busybox \
        opkg \
        libgcc \
        grub \
        xserver-xorg \
        dialog \
        xf86-input-evdev \
        xf86-video-fbdev \
        xf86-video-intel \
        xterm \
        xauth \
        encodings \
        font-util \
        xorg-minimal-fonts \
        xinit \
        pcmciautils \
        usbutils \
        wireless-tools \
        wpa-supplicant \
        dbus-x11 \
        update-rc.d \
"


#PACKAGE_REMOVE = "mesa \
#	mesa-dri \
#        xserver-xorg-extension-dri \
#        xserver-xorg-extension-dri2 \
#        xserver-xorg-extension-glx \
#        libdrm \
#        libdrm-kms \
#        libdrm-drivers \
#	kernel \
#	kernel-image \
#"

IMAGE_BASENAME = "opencocon"
IMAGE_FSTYPES = " tar.gz "

inherit image

