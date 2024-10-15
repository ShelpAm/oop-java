#!/bin/env bash

if [ $# -ne 1 ]; then
  echo 'Usage: run.sh Week<week-number>'
  exit 1
fi

# -d specifies output dir
report=$(javac -d bin src/*.java ./src/DataStructureAndAlgorithm/*.java src/$1/*.java 2>&1 | tee /dev/stderr)
error=$(echo $report | grep error)
if [[ -n $error ]] then
  echo Compilation failed. Running is stopped.
  exit 1
fi

# -cp specifies [c]lass [p]ath
java -cp bin Main

