require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

#SRC_URI += "file://0001-ptrace.h-remove-ptrace_peeksiginfo_args.patch"
#SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

KORG_ARCHIVE_COMPRESSION = "xz"

SRC_URI[md5sum] = "ef927e91cf8b8c4ddf98847341ccf2c8"
SRC_URI[sha256sum] = "95f9be5a26f6c15d21528ecdb2cd3307fc99c715cfb3bce13843de8393f67028"

