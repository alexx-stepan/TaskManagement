CONTAINER_NAME=$1

if [ "$(docker ps -a -f name=$CONTAINER_NAME)" ]; then
    if [ "$(docker ps -f name=$CONTAINER_NAME status=running)" ]; then
        docker stop $CONTAINER_NAME
    fi

    docker rm $CONTAINER_NAME
fi
