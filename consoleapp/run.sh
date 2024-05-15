#!/usr/bin/env bash
script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$script_dir"
java -cp build/libs/consoleapp-1.0-SNAPSHOT.jar org.example.Main
