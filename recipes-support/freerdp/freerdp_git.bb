# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

#inherit gitpkgv

PV = "gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "${INC_PR}.10"

SRCREV = "de9156e4a0dd6bf71b88d3c4bbd875ea48cd380a"
# Experimental:
# v7
# SRCREV = "15a22eb9c9656fab41cefbe9e39e4b70162bece2"

# Stable tree:
##SRCREV = "15069020d398c203df921da93eb1b72f55b6010a"

SRC_URI = "git://github.com/FreeRDP/FreeRDP.git \
"

#           file://futimens_cocon.patch

GITPKGVTAG = "${SRCREV}"

S = "${WORKDIR}/git"

#CMAKE_MODULE_PATH += " ${S}/cmake/ "

