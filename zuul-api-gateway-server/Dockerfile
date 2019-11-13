FROM openjdk:11

EXPOSE 8765

ADD build/libs/zuul-api-gateway-server-0.0.1-SNAPSHOT.jar zuul-api-gateway-server.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-api-gateway-server.jar"]