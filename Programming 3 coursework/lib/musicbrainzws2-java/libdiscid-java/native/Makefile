# libdiscid-java makefile

# NOTE: if you are getting jni.h not found errors, ensure to run
# via ant (ie ant native) and not via 'make'.  If you want to run directly
# with make, you'll have to define the following variables


# v-- these properties are passed in by the ant build script.  should work fine with standard jvms --v
prefix=${java.home}/..
OSNAME=${os.name}
ARCHNAME=${os.arch}
LIBDISCID_PREFIX=/usr
#


JAVADIR=$(prefix)
CC=gcc
CPP_INCLUDES=-I$(JAVADIR)/include -I$(JAVADIR)/include/$(OSNAME) -I${LIBDISCID_PREFIX}/include
RM_F=rm -f
MKDIR_P=mkdir -p

OBJDIR=../build

LIBBASENAME=libdiscidjava
LIBDEST=$(LIBBASENAME).so.1.0
LIBDEST_ABSOLUTE=$(ABS_PREFIX)/$(LIBDEST)

LIBS=-L ${LIBDISCID_PREFIX}/lib -ldiscid

JAVAH = javah -force -classpath $(OBJDIR)

JNIOBJ=\
	org_musicbrainz_discid_libdiscid.o

OBJECTS=$(JNIOBJ) 

JNICLASSFILES=\
	LibDiscId.class

JNIHEADERS:=$(JNIOBJ:.o=.h)

JNICLASSES=\
	org.musicbrainz.discid.LibDiscId \
	test.ca.benow.jni.LinkerTest

#----------------- rules -------------------

all: simple test

jni:
  

simple:
	echo Using JAVA_HOME=$(JAVADIR)
	$(MKDIR_P) $(OSNAME)/$(ARCHNAME)
	$(JAVAH) -d . $(JNICLASSES)
	$(CC) -Wall -Wstrict-prototypes -fpic -g -shared \
	$(CPP_INCLUDES) \
	$(LIBS) \
	-o $(OSNAME)/$(ARCHNAME)/libdiscid-java.so org_musicbrainz_discid_LibDiscId.c
	echo Successfully compiled to native/$(OSNAME)/$(ARCHNAME)

clean:
	$(RM_F) $(LIBDEST) $(JNIHEADERS) *.o *~

test:
	gcc -Wall -Wstrict-prototypes $(ARCH) -fpic -g -shared $(CPP_INCLUDES) test_ca_benow_jni_LinkerTest.c -o $(OSNAME)/$(ARCHNAME)/liblinkertest.so  
	cd ..; java -cp build:libdiscid-java.jar -Djava.library.path=native/$(OSNAME)/$(ARCHNAME) test.ca.benow.jni.LinkerTest

