require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

KORG_ARCHIVE_COMPRESSION = "xz"

SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

SRC_URI[md5sum] = "94cb4721ea83c0366b109258b3b1308c"
SRC_URI[sha256sum] = "9756377bf654d52135273c1b39a8afd8a99ee5bddb7d977c34827e49bcb701c3"

