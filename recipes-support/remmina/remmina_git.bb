LICENSE = "GPLv2"
DEPENDS = "libvncserver xserver-xorg freerdp libgcrypt libssh zlib gettext "
PR = "r0"

#DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/FreeRDP/Remmina.git;protocol=git;branch=master" 

SRCREV = "9c2b9410ba5dd9bac7778e2bd797fe69d01ff27f"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DWITH_VTE=OFF -DWITH_TELEPATHY=OFF -DWITH_AVAHI=OFF \
		   -DWITH_GNOMEKEYRING=OFF -DCMAKE_BUILD_TYPE=Release"
LDFLAGS += " -lintl "
OECMAKE_C_FLAGS += " -lintl "

inherit cmake gettext

#PACKAGES = "${PN}" 
FILES_${PN} += "${datadir}/icons"
FILES_${PN}-dbg += "${libdir}/remmina/plugins/.debug"

LIC_FILES_CHKSUM = "file://remmina/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

