#!/bin/sh

set -e

echo "> Check tm_database for availability"

while ! nc -z db 5432; do
    sleep 1
done

echo "> tm_database is up"

java -jar /app/taskmanagement.jar
