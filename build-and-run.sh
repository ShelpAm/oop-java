#!/bin/env bash

if [ $# -ne 1 ]; then
  echo 'Usage: build-and-run.sh Week<week-number>'
  exit 1
fi

# -d specifies output dir
javac src/*.java -d bin

# -cp specifies [c]lass [p]ath
java -cp bin $1

