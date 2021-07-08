SUMMARY = "SELinux binary policy manipulation library"
DESCRIPTION = "libsepol provides an API for the manipulation of SELinux binary policies. \
It is used by checkpolicy (the policy compiler) and similar tools, as well \
as by programs like load_policy that need to perform specific transformations \
on binary policies such as customizing policy boolean settings."
SECTION = "base"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

require selinux_common.inc

inherit lib_package

SRC_URI += "file://CVE-2021-36084.patch;striplevel=2 \
            file://CVE-2021-36085.patch;striplevel=2 \
            file://CVE-2021-36086.patch;striplevel=2 \
           "

S = "${WORKDIR}/git/libsepol"

# Change RANLIB for cross compiling, use host-tools $(AR) rather than
# local ranlib.
EXTRA_OEMAKE += "RANLIB='$(AR) s'"

DEPENDS += "flex-native"

BBCLASSEXTEND = "native"
