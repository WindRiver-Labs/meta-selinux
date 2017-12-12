SUMMARY = "Python module for handling IPv4 and IPv6 Addresses and Networks"
DESCRIPTION = "IPy is a Python module for handling IPv4 and IPv6 Addresses and Networks \ 
in a fashion similar to perl's Net::IP and friends. The IP class allows \
a comfortable parsing and handling for most notations in use for IPv4 \
and IPv6 Addresses and Networks."
SECTION = "devel/python"
HOMEPAGE = "https://github.com/haypo/python-ipy"
DEPENDS = "python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=848d24919845901b4f48bae5f13252e6"

SRCREV = "463b2be0646c7fb48f826f973aac216632f44e14"
PV = "0.83+git${SRCPV}"
SRC_URI = "git://github.com/autocracy/python-ipy.git;branch=master \
"

S = "${WORKDIR}/git"
B = "${S}"

inherit distutils

# need to export these variables for python-config to work
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append() {
	install -d ${D}/${datadir}/doc/${BPN}-${PV}
	install AUTHORS COPYING ChangeLog README.rst ${D}/${datadir}/doc/${BPN}-${PV}
}
