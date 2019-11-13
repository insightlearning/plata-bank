FROM openjdk:11

EXPOSE 8080

ADD build/libs/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customer-service.jar"]