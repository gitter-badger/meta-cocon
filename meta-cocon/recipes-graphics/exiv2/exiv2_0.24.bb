# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Image metadata library and tools"
HOMEPAGE = "http://www.exiv2.org/"
PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=625f055f41728f84a8d7938acc35bdc2"

inherit cmake gettext
SRC_URI = "http://www.exiv2.org/exiv2-${PV}.tar.gz"

SRC_URI[md5sum] = "b8a23dc56a98ede85c00718a97a8d6fc"
SRC_URI[sha256sum] = "f4a443e6c7fb9d9f5e787732f76969a64c72c4c04af69b10ed57f949c2dfef8e"
