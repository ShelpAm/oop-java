#!/bin/env bash

if [ $# -ne 1 ]; then
  echo 'Usage: run.sh Week<week-number>'
  exit 1
fi

# -d specifies output dir
javac -d bin src/*.java ./src/DataStructureAndAlgorithm/*.java src/$1/*.java

# -cp specifies [c]lass [p]ath
java -cp bin Main

