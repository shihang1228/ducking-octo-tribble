#!/bin/sh
javac -classpath $CATALINA_HOME/lib/servlet-api.jar  -d  target/classes/ src/main/java/com/bodejidi/WebServlet.java
