#!/bin/sh
cd ../
gradle fatJar
java -jar build/libs/TodoApp-1.0-SNAPSHOT-all.jar $1