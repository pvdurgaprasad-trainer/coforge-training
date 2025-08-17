# coforge-training

docker build -t pvdurgaprasadtrainer/lms-be:latest .
docker build -t pvdurgaprasadtrainer/lms-rct-app:latest .

docker push pvdurgaprasadtrainer/lms-be:latest
docker push pvdurgaprasadtrainer/lms-rct-app:latest
