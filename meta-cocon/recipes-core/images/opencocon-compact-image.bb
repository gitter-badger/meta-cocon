# opencocon master image

IMAGE_PKGTYPE = "ipk"


IMAGE_NAME = "opencocon-compact-${DISTRO_VERSION}-${MACHINE}"

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
xserver-xorg-module-xaa \
xserver-xorg-multimedia-modules \
xserver-xorg-fbdev \
xf86-input-synaptics \
xf86-input-evdev \
xf86-input-keyboard \
xf86-input-mouse \
xf86-video-apm \
xf86-video-ark \
xf86-video-ast \
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
ttf-vlgothic \
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
linux-firmware-broadcom \
linux-firmware-agere \
linux-firmware-iwlwifi \
linux-firmware-marvell \
linux-firmware-ralink \
linux-firmware-realtek \
linux-firmware-vt6656 \
zd1211-firmware \
kernel-firmware-3ccfem556 \
kernel-firmware-3cxem556 \
kernel-firmware-d101m-ucode \
kernel-firmware-d101s-ucode \
kernel-firmware-d102e-ucode \
kernel-firmware-dp83903 \
kernel-firmware-ds1-ctrl \
kernel-firmware-ds1-dsp \
kernel-firmware-ds1e-ctrl \
kernel-firmware-g200-warp \
kernel-firmware-g400-warp \
kernel-firmware-la-pcm \
kernel-firmware-maestro3-assp-kernel \
kernel-firmware-maestro3-assp-minisrc \
kernel-firmware-ne2k \
kernel-firmware-new-code-fix \
kernel-firmware-new-code \
kernel-firmware-pcmlm28 \
kernel-firmware-pe-200 \
kernel-firmware-pe520 \
kernel-firmware-r100-cp \
kernel-firmware-r128-cce \
kernel-firmware-r200-cp \
kernel-firmware-r300-cp \
kernel-firmware-r420-cp \
kernel-firmware-r520-cp \
kernel-firmware-r600-me \
kernel-firmware-r600-pfp \
kernel-firmware-rs600-cp \
kernel-firmware-rs690-cp \
kernel-firmware-rs780-me \
kernel-firmware-rs780-pfp \
kernel-firmware-rv610-me \
kernel-firmware-rv610-pfp \
kernel-firmware-rv620-me \
kernel-firmware-rv620-pfp \
kernel-firmware-rv630-me \
kernel-firmware-rv630-pfp \
kernel-firmware-rv635-me \
kernel-firmware-rv635-pfp \
kernel-firmware-rv670-me \
kernel-firmware-rv670-pfp \
kernel-firmware-rv710-me \
kernel-firmware-rv710-pfp \
kernel-firmware-rv730-me \
kernel-firmware-rv730-pfp \
kernel-firmware-rv770-me \
kernel-firmware-rv770-pfp \
kernel-firmware-tamarack \
kernel-firmware-tg1 \
kernel-firmware-tg2 \
kernel-firmware-tg3-tso5 \
kernel-firmware-tg3-tso \
kernel-firmware-tg3 \
kernel-firmware-trigger-code-fix \
kernel-firmware-trigger-code \
kernel-firmware-typhoon \
kernel-firmware-xilinx7od \
kernel-firmware-yss225-registers \
b43-fwcutter \
"

RDEPENDS = "${COCON_BASE_PACKAGES} \
${COCON_XBASE_PACKAGES} \
${COCON_XEXT_PACKAGES} \
${COCON_APP_PACKAGES} \
${COCON_HDDIMAGE_PACKAGES} \
${COCON_NONFREE_FIRMWARE} \
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
