require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI += "file://0001-ptrace.h-remove-ptrace_peeksiginfo_args.patch"
SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

SRC_URI[md5sum] = "d4cdc01af11b9a49f34c406dde7ee430"
SRC_URI[sha256sum] = "fcff3fd2132a1a6d6b797a8440eb1b98f558e57360630af4ecfbb85284f257d1"

