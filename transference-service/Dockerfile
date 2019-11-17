FROM openjdk:11

EXPOSE 8080

ADD build/libs/transference-service-0.0.1-SNAPSHOT.jar transference-service.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/transference-service.jar"]