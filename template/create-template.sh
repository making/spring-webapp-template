#!/bin/sh
VERSION=1.0.0.`date +%Y%m%d%H%M%S`
BASE=`pwd`
PROJECT=spring-webapp-template-$VERSION
TMPLNAME=template
rm -f *.zip
rm -rf $PROJECT

mkdir -p $PROJECT
cd $PROJECT

echo "zip template"
mkdir -p $TMPLNAME

cp -r $BASE/../src $TMPLNAME
#cp -r $BASE/../.settings $TMPLNAME
#cp -r $BASE/../target $TMPLNAME
#cp $BASE/../.project $TMPLNAME
#cp $BASE/../.classpath $TMPLNAME
cp $BASE/../pom.xml $TMPLNAME
zip -qr $TMPLNAME.zip $TMPLNAME/*
rm -rf $TMPLNAME

cd $BASE

echo "copy configurations"
sed -e s/\$\{version\}/$VERSION/ template.master.xml > $PROJECT/template.xml
cp wizard.json $PROJECT

echo "zip project"
zip -qr $PROJECT.zip $PROJECT

echo "update descriptors.xml"
sed -e s/\$\{version\}/$VERSION/ descriptors.master.xml > descriptors.xml
sed -e s/\$\{version\}/$VERSION/ descriptors-local.master.xml > descriptors-local.xml

echo "clean"
rm -rf $PROJECT