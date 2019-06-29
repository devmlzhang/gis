#FROM openjdk:8-jdk-alpine
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD gis.jar gis.jar
RUN sh -c 'touch /gis.jar'
#时间同步
ENV TZ=Asia/Shanghai
RUN apk add tzdata
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gis.jar" ]
