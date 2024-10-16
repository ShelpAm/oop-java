#!/bin/env bash

if [ $# -ne 1 ]; then
  echo 'Usage: run.sh week<week-number>'
  exit 1
fi

# -d specifies output dir
# The '^' in ${variable-name^} capitalize the first letter in the string.
report=$(javac -Xlint:unchecked -d bin src/*.java ./src/DataStructureAndAlgorithm/*.java \
  src/${1^}/*.java 2>&1 | tee /dev/stderr)
error=$(echo $report | grep error)
if [[ -n $error ]] then
  echo Compilation failed. Running is stopped.
  exit 1
fi

java --class-path bin shelpam.$1.Main
# –enableassertions:shelpam 

