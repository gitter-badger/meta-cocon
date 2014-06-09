DEFAULTTUNE ?= "i486"

require conf/machine/include/x86/arch-x86.inc

# Extra tune features
TUNEVALID[i486] = "Enable i486 specific processor optimizations"
TUNE_CCARGS += "${@bb.utils.contains("TUNE_FEATURES", "i486", "-march=i486", "", d)}"

# Extra tune selections
AVAILTUNES += "i486"
TUNE_FEATURES_tune-i486 = "${TUNE_FEATURES_tune-x86} i486"
BASE_LIB_tune-i486 = "lib"
TUNE_PKGARCH_tune-i486 = "i486"
PACKAGE_EXTRA_ARCHS_tune-i486 = "${PACKAGE_EXTRA_ARCHS_tune-x86} i386 i486"

#FEED_ARCH = "i486"

