#!/bin/sh

javac src/*.java -d bin && java -cp bin $1
