# opencocon master image

IMAGE_PKGTYPE = "ipk"


IMAGE_NAME = "opencocon-${DISTRO_VERSION}-${MACHINE}"

# TODO : postprocess?
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
util-linux-cfdisk \
util-linux-fdisk \
e2fsprogs-badblocks \
e2fsprogs-mke2fs \
e2fsprogs-e2fsck \
udev \
kbd \
kbd-keymaps \
dmidecode \
kernel-modules \
consolekit \
xuser-account \
eject \
"

COCON_XBASE_PACKAGES = " \
xserver-xorg \
xserver-xorg-xephyr \
xserver-xorg-extension-dbe \
xserver-xorg-extension-extmod \
xserver-xorg-extension-glx \
xserver-xorg-module-libint10 \
xserver-xorg-module-libwfb \
xserver-xorg-module-exa \
xserver-xorg-multimedia-modules \
xserver-xorg-fbdev \
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
xf86-video-intel \
xf86-video-mach64 \
xf86-video-mga \
xf86-video-modesetting \
xf86-video-nouveau \
xf86-video-nv \
xf86-video-openchrome \
xf86-video-r128 \
xf86-video-rendition \
xf86-video-s3 \
xf86-video-s3virge \
xf86-video-sis \
xf86-video-tdfx \
xf86-video-trident \
xf86-video-tseng \
xf86-video-vesa \
xf86-video-voodoo \
xf86-video-xgi \
xf86-video-xgixp \
xcb-util-image \
xcb-util-keysyms \
xcb-util-renderutil \
xcb-util-wm \
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
ttf-koruri \
xrandr \
xkeyboard-config \
freetype \
setxkbmap \
xmodmap \
openssh-ssh \
gnome-icon-theme \
hicolor-icon-theme \
xdpyinfo \
x11perf \
xf86-video-savage \
xf86-video-siliconmotion \
xf86-video-neomagic \
gnome-keyring \
network-manager-applet \
polkit-gnome \
opengalax \
xinput-calibrator \
networkmanager-openvpn \
openvpn \
networkmanager-pptp \
pptp-linux \
openswan \
networkmanager-openswan \
"


COCON_XEXT_PACKAGES = " \
libdrm \
libdrm-kms \
libdrm-intel \
libdrm-nouveau \
libdrm-radeon \
mesa-driver-i915 \
mesa-driver-i965 \
mesa-driver-nouveau-vieux \
mesa-driver-r200 \
mesa-driver-radeon \
mesa-driver-swrast \
libdricore \
libegl-mesa \
libgbm \
libgl-mesa \
libglapi \
libgles1-mesa \
libgles2-mesa \
"


COCON_APP_PACKAGES = " \
freerdp \
libfreerdp \
libfreerdp-plugin-tsmf \
libfreerdp-plugin-tsmf-pulse \
libfreerdp-plugin-tsmf-alsa \
libfreerdp-plugin-rdpsnd \
libfreerdp-plugin-rdpsnd-pulse \
libfreerdp-plugin-rdpsnd-alsa \
libfreerdp-plugin-audin \
libfreerdp-plugin-audin-pulse \
libfreerdp-plugin-audin-alsa \
libfreerdp-plugin-drdynvc \
webkit-gtk \
libvncserver \
openssl \
gnutls \
gnutls-openssl \
libgcrypt \
libgpg-error \
libjpeg-turbo \
matchbox-wm \
lxterminal \
lxrandr \
alsa-utils-alsamixer \
alsa-utils-aplay \
alsa-utils-amixer \
alsa-utils-speakertest \
alsa-utils-alsactl \
pulseaudio \
pulseaudio-module-alsa-card \
pulseaudio-module-alsa-sink \
pulseaudio-module-alsa-source \
pulseaudio-module-esound-protocol-tcp \
pulseaudio-module-native-protocol-tcp \
pulseaudio-module-native-protocol-unix \
pulseaudio-module-x11-bell \
pulseaudio-module-mmkbd-evdev \
pulseaudio-module-udev-detect \
pulseaudio-module-x11-publish \
pulseaudio-server \
midori \
cyrus-sasl \
gtk-vnc \
lxpanel \
libwnck \
libnotify \
viewnior \
celt \
spice-gtk \
dropbear \
python-pygtk \
ntpdate \
"

COCON_HDDIMAGE_PACKAGES = " \
opencocon-init \
opencocon-init-doc \
grub-legacy \
"

COCON_NONFREE_FIRMWARE = " \
linux-firmware-ar9170 \
linux-firmware-ath6k \
linux-firmware-ath9k \
linux-firmware-bcm4329 \
linux-firmware-bcm4330 \
linux-firmware-bcm4334 \
linux-firmware-iwlwifi-6000g2a-5 \
linux-firmware-iwlwifi-6000g2b-6 \
linux-firmware-iwlwifi-7260-7 \
linux-firmware-iwlwifi-6000g2a-6 \
linux-firmware-iwlwifi-135-6 \
linux-firmware-marvell-license \
linux-firmware-sd8686 \
linux-firmware-sd8787 \
linux-firmware-sd8797 \
linux-firmware-ralink \
linux-firmware-rtl8192cu \
linux-firmware-rtl8192ce \
linux-firmware-vt6656 \
linux-firmware-radeon \
linux-firmware-rtl8192su \
zd1211-firmware \
b43-fwcutter \
"

COCON_BSP_PACKAGES = "v86d \
"

RDEPENDS = "${COCON_BASE_PACKAGES} \
${COCON_XBASE_PACKAGES} \
${COCON_XEXT_PACKAGES} \
${COCON_APP_PACKAGES} \
${COCON_HDDIMAGE_PACKAGES} \
${COCON_NONFREE_FIRMWARE} \
${COCON_BSP_PACKAGES} \
"

IMAGE_INSTALL = "${COCON_BASE_PACKAGES} \
${COCON_XBASE_PACKAGES} \
${COCON_XEXT_PACKAGES} \
${COCON_APP_PACKAGES} \
${COCON_HDDIMAGE_PACKAGES} \
${COCON_NONFREE_FIRMWARE} \
"



IMAGE_BASENAME = "opencocon"
IMAGE_FSTYPES = " tar.gz squashfs "

inherit image
