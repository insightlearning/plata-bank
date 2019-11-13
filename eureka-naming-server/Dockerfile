FROM openjdk:11

EXPOSE 8761

ADD build/libs/eureka-naming-server-0.0.1-SNAPSHOT.jar eureka-naming-server.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-naming-server.jar"]