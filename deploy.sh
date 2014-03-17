#!/bin/sh

cp -r src/main/webapp/* $CATALINA_HOME/webapps/webservlet/
cp -r  target/classes/  $CATALINA_HOME/webapps/webservlet/WEB-INF/
cp -r  lib $CATALINA_HOME/webapps/webservlet/WEB-INF/
