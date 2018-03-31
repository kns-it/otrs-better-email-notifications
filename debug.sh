#!/usr/bin/env bash

PAYARA_VERSION="5.181"
PAYARA_JAR=payara-micro.jar

if [ ! -e "$PAYARA_JAR" ]; then
    curl -o $PAYARA_JAR $"https://s3-eu-west-1.amazonaws.com/payara.fish/Payara+Downloads/$PAYARA_VERSION/payara-micro-$PAYARA_VERSION.jar"
fi

./gradlew build
WAR_FILE=$(find $"`pwd`/build/libs/" -name "*.war" | tac | tail -n 1)
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -jar $PAYARA_JAR --deploy $WAR_FILE
