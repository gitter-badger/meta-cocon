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


IMAGE_NAME = "compact-${DISTRO_VERSION}-${MACHINE}"

#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DISTRO_UPDATE_ALTERNATIVES ?= "${PREFERRED_PROVIDER_virtual/update-alternatives}"

DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"
ONLINE_PACKAGE_MANAGEMENT = "no"

# FIXME: We need a distro-indendent way of specifying feed configs.
# Once the RFC for the DISTRO_FEED_CONFIGS variable name is approved,
# we can remove this default definition and set it in the distro config.
#DISTRO_FEED_CONFIGS ?= "${ANGSTROM_FEED_CONFIGS}"


COCON_BASE_PACKAGES = " \
base-files \
base-passwd \
keymaps \
uclibc \
uclibc-utils \
busybox \
opkg \
libgcc \
dialog \
pcmciautils \
usbutils \
wireless-tools \
wpa-supplicant \
update-rc.d \
networkmanager \
polkit \
util-linux \
e2fsprogs \
udev \
kbd \
kbd-keymaps \
"

COCON_XBASE_PACKAGES = " \
xserver-xorg \
xserver-xorg-xephyr \
xserver-xorg-extension-dbe \
xserver-xorg-extension-dri \
xserver-xorg-extension-dri2 \
xserver-xorg-extension-extmod \
xserver-xorg-extension-glx \
xserver-xorg-module-libint10 \
xserver-xorg-module-libwfb \
xserver-xorg-module-xaa \
xserver-xorg-multimedia-modules \
xf86-input-synaptics \
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xf86-video-apm \
xf86-video-ark \
xf86-video-ast \
xf86-video-ati \
xf86-video-chips \
xf86-video-cirrus \
xf86-video-fbdev \
xf86-video-geode \
xf86-video-glint \
xf86-video-i128 \
xf86-video-i740 \
xf86-video-intel \
xf86-video-mach64 \
xf86-video-mga \
xf86-video-modesetting \
xf86-video-neomagic \
xf86-video-nouveau \
xf86-video-nv \
xf86-video-openchrome \
xf86-video-r128 \
xf86-video-rendition \
xf86-video-s3 \
xf86-video-s3virge \
xf86-video-savage \
xf86-video-siliconmotion \
xf86-video-sis \
xf86-video-tdfx \
xf86-video-trident \
xf86-video-tseng \
xf86-video-vesa \
xf86-video-voodoo \
xf86-video-xgi \
xf86-video-xgixp \
xauth \
encodings \
font-util \
font-alias \
encodings \
xorg-minimal-fonts \
xinit \
dbus-x11 \
liberation-fonts \
ttf-bitstream-vera \
ttf-sazanami-gothic \
xrandr \
xkeyboard-config \
freetype \
setxkbmap \
xmodmap \
"

COCON_XEXT_PACKAGES = " \
libgl \
libglu \
mesa-dri-driver-i810 \
mesa-dri-driver-i915 \
mesa-dri-driver-i965 \
mesa-dri-driver-mach64 \
mesa-dri-driver-mga \
mesa-dri-driver-nouveau-vieux \
mesa-dri-driver-r128 \
mesa-dri-driver-r200 \
mesa-dri-driver-r300 \
mesa-dri-driver-r600 \
mesa-dri-driver-radeon \
mesa-dri-driver-savage \
mesa-dri-driver-sis \
mesa-dri-driver-swrast \
mesa-dri-driver-tdfx \
mesa-dri-driver-unichrome \
libdrm \
libdrm-kms \
libdrm-drivers \
"

COCON_APP_PACKAGES = " \
freerdp \
libvncserver \
openssl \
gnutls \
gnutls-openssl \
libgcrypt \
libgpg-error \
libjpeg-turbo \ 
matchbox-wm \
lxterminal \
pulseaudio \
cyrus-sasl \
gtk-vnc \
pong-clock \
lxpanel \
libwnck \
libnotify \
network-manager-applet \
"

COCON_HDDIMAGE_PACKAGES = " \
opencocon-init \
grub \
"

RDEPENDS = "${COCON_BASE_PACKAGES} \
${COCON_XBASE_PACKAGES} \
${COCON_APP_PACKAGES} \
${COCON_HDDIMAGE_PACKAGES} \
"

IMAGE_INSTALL = "${COCON_BASE_PACKAGES} \
${COCON_XBASE_PACKAGES} \
${COCON_APP_PACKAGES} \
${COCON_HDDIMAGE_PACKAGES} \
"



IMAGE_BASENAME = "compact"
IMAGE_FSTYPES = " tar.gz "

inherit image

