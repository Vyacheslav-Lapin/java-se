#!/usr/bin/env bash

cd build/classes/java/main
java -Dcom.sun.management.jmxremote \
     -Dcom.sun.management.jmxremote.port=1617 \
     -Dcom.sun.management.jmxremote.authenticate=false \
     -Dcom.sun.management.jmxremote.ssl=false \
     com.luxoft.training.javase.bankapp.jmx.SimpleAgent