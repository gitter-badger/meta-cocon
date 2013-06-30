# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

#inherit gitpkgv

PV = "gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "${INC_PR}.9"

# Experimental:
SRCREV = "15a22eb9c9656fab41cefbe9e39e4b70162bece2" 
# SRCREV = "b4b0fb06429b1ae2bae1429cc1a930509babf57e"  # Tested

# Stable tree:
##SRCREV = "15069020d398c203df921da93eb1b72f55b6010a"

SRC_URI = "git://github.com/FreeRDP/FreeRDP.git \
           file://futimens_cocon_v2.patch \
           file://06d06fdd2d45350f144ff3d79353e817b30811a7.patch \ 
"
GITPKGVTAG = "${SRCREV}"

S = "${WORKDIR}/git"

#CMAKE_MODULE_PATH += " ${S}/cmake/ "

