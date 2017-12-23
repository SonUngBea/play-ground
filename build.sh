#/bin/sh
./gradlew build
docker build -t thsdndqo00/webserver .
sudo docker login
sudo docker push thsdndqo00/webserver