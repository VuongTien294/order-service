FROM openjdk:8

COPY target/*.jar order-service.jar
EXPOSE 8284
ENTRYPOINT ["java","-jar","/order-service.jar"]