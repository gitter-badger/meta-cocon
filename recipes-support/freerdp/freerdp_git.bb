# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

# inherit gitpkgv cmake

PV = "gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "${INC_PR}.5"

#SRCREV = "7fe240df119dcf585f97e3b696c863b49be44b9a"
SRCREV = "fd0e93c35fa9cf2d6a9ac862ea87004ef7ef0aa1"
SRC_URI = "git://github.com/FreeRDP/FreeRDP.git;protocol=git \
"
GITPKGVTAG = "${SRCREV}"

# ;branch=1.0-stable"

S = "${WORKDIR}/git"

