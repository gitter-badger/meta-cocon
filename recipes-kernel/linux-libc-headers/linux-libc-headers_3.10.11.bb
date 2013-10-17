require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

SRC_URI += "file://0001-ptrace.h-remove-ptrace_peeksiginfo_args.patch"
SRC_URI += "file://scripts-Makefile.headersinst-install-headers-from-sc.patch"

SRC_URI[md5sum] = "1ea7f574752195d633aecf8a6ecc0891"
SRC_URI[sha256sum] = "b7a6da46b811fda55c124633978f70d219acef5f8b2691ae7d0bbfff03949309"

