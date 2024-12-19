#!/bin/env bash

JAVA='java-23'
JAVAC='javac'

PREFIX_DIR='./src/main/java/'
SRC=$(find . -name '*.java')

if [ $# -ne 1 ]; then
  echo 'Usage: build-and-run.sh week<week-number>'
  exit 1
fi

# -d specifies output dir
report=$(${JAVAC} -Xlint:unchecked -d bin ${SRC} 2>&1 | tee /dev/stderr)
error=$(echo $report | grep error)
if [[ -n $error ]] then
  echo Compilation failed. Running is stopped.
  exit 1
fi

${JAVA} -enableassertions --class-path bin shelpam.$1.Main

