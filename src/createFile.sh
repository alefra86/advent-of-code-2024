#!/bin/bash

DAY=$(printf "%02d\n" "$1")
cp "DaySkeleton.kt" "Day$DAY.kt"
touch "Day$DAY.txt"
touch "Day${DAY}_test.txt"