#!/bin/sh
VERSION=1.0.0
BASE=`pwd`
PROJECT=spring-webapp-template-$VERSION
TMPLNAME=template
rm -rf $PROJECT

mkdir -p $PROJECT
cd $PROJECT

echo "zip template"
mkdir -p $TMPLNAME

cp -r $BASE/../src $TMPLNAME
cp -r $BASE/../.settings $TMPLNAME
cp -r $BASE/../target $TMPLNAME
cp $BASE/../.project $TMPLNAME
cp $BASE/../.classpath $TMPLNAME
cp $BASE/../pom.xml $TMPLNAME
zip -qr $TMPLNAME.zip $TMPLNAME/*
rm -rf $TMPLNAME

cd $BASE
pwd

echo "copy configurations"
cp template.xml $PROJECT
cp wizard.json $PROJECT

echo "zip project"
zip -qr $PROJECT.zip $PROJECT

echo "clean"
rm -rf $PROJECT

