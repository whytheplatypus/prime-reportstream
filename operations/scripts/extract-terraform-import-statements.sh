#!/bin/bash

IFS=$'\n'
ResourceList=$(terraform state list)

for Resource in $ResourceList; do
  printf "terraform import %s %s\n" "${Resource}" "<id>"
  terraform state show "${Resource}"
  printf "\n\n"
done