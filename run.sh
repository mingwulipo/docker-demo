#!/bin/bash

#install报错，也会往下走，注意看install成功否
mvn clean install -Dmaven.test.skip=true

tag=`head -1 version`
echo "tag:$tag"
img="harbor.fastai.top/java/docker-demo:$tag"
echo "image:$img"

docker build -t $img ./
docker rm -v -f docker-demo && docker run -p 8080:8080 -v /etc/localtime:/etc/localtime:ro -v /etc/timezone:/etc/timezone:ro --name docker-demo -d $img
echo "创建镜像和启动容器成功!"

#push多次，tag相同的话，最新的才有tag，旧的没有tag
docker push $img
#其他机器拉取镜像,docker pull $img，必须加tag，否则默认tag是latest，但是没有这个tag

echo "推送镜像成功!"