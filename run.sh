#!/bin/bash
if [ ${PORT+x} ]; then
    echo "port: $PORT"
    java -jar ./rsoi.jar --server.port=$PORT
else
    java -jar ./rsoi.jar
fi
