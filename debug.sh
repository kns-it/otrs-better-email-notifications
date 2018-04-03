#!/usr/bin/env bash

PAYARA_VERSION="5.181"
PAYARA_JAR=payara-micro.jar

export CONFIG_FILE_PATH="/home/baez/sources/Github/kns-it/otrs-better-email-notifications/src/test/resources/demo-config.yaml"

if [ ! -e "$PAYARA_JAR" ]; then
    curl -o $PAYARA_JAR $"https://s3-eu-west-1.amazonaws.com/payara.fish/Payara+Downloads/$PAYARA_VERSION/payara-micro-$PAYARA_VERSION.jar"
fi

./gradlew build
WAR_FILE=$(find $"`pwd`/build/libs/" -name "*.war" | tac | tail -n 1)
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 \
     --add-modules java.xml.bind \
     --add-opens java.base/jdk.internal.loader=ALL-UNNAMED \
     -jar $PAYARA_JAR \
     --deploy $WAR_FILE
