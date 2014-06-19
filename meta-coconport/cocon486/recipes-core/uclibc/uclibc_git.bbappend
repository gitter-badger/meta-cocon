FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# cocon486 is need i486 at least.

do_configure_prepend() {
    echo "CONFIG_486=y"  >> ${WORKDIR}/uClibc.machine
    echo "TARGET_SUBARCH=\"i486\"" >> ${WORKDIR}/uClibc.machine
}

