#!/bin/bash

function postDrinkData() {
  local timeStamp=$1
  local value=$((1 + $RANDOM % 10))
  local url="http://localhost:8080/weather-feeling/add"

  curl --request POST \
    --url $url \
    --header 'Content-Type: application/json' \
    --header 'User-Agent: bash/8.6.1' \
    --data "{
      \"value\": $value,
      \"user\": {
        \"username\": \"dev\"
      },
      \"timeStamp\": $timeStamp
    }"
}

for i in {1..5}
do
  timeStamp=$(($(date +%s)))000
  postDrinkData $timeStamp
done

for i in {1..5}
do
  # create a timestamp for yesterday
  timeStamp=$(($(date +%s) - 86400))000
  postDrinkData $timeStamp
done

for i in {1..5}
do
  # create a timestamp for the day before yesterday
  timeStamp=$(($(date +%s) - 2*86400))000
  postDrinkData $timeStamp
done
