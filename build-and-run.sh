#!/bin/sh

# -d specifies output dir
javac src/*.java -d bin

# -cp specifies [c]lass [p]ath
java -cp bin $1

