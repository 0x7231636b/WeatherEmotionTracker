#!/bin/bash

DOCKER_HUB_USERNAME=rjck

# Before this works, you need to login to docker with `docker login`
docker buildx create --use
docker buildx build --platform linux/amd64,linux/arm64 -t $DOCKER_HUB_USERNAME/drink-smart-backend:dev --push .
