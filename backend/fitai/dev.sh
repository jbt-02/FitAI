#!/usr/bin/env bash

set -a
source .env
set +a

echo "Enviroment variables loaded"
./mvnw spring-boot:run
