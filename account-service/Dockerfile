FROM openjdk:11

EXPOSE 8080

ADD build/libs/account-service-0.0.1-SNAPSHOT.jar account-service.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account-service.jar"]