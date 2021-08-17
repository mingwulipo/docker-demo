#!/bin/bash

mvn clean install -Dmaven.test.skip=true

case $1 in
    docker-demo)
        echo "开始构建docker-demo项目，请记得拉取最新代码及编译通过"
        docker build -t docker-demo:latest ./
        docker rm -v -f docker-demo && docker run -p 8080:8080 -v /etc/localtime:/etc/localtime:ro -v /etc/timezone:/etc/timezone:ro --name docker-demo -d docker-demo:latest
	;;
    *)
        echo "未知模块，请输入正确的参数"
esac
