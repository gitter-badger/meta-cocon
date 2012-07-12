# Copyright (C) 2010, 2011, O.S. Systems Software Ltda.
# Released under the MIT license

include freerdp.inc

inherit gitpkgv cmake

PV = "gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "${INC_PR}.3"

#SRCREV = "58c36d60cb82e9f4c012c6358ea98c29d195e53c"
SRCREV = "cc9e584301f33c41409ed2aa31c4818e6cef5b9d"
SRC_URI = "git://github.com/FreeRDP/FreeRDP.git;protocol=git"

# ;branch=1.0-stable"

S = "${WORKDIR}/git"


