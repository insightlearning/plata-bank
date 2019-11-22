FROM openjdk:11

EXPOSE 8080

ADD build/libs/payee-service-0.0.1-SNAPSHOT.jar payee-service.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/payee-service.jar"]