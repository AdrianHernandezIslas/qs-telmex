FROM openjdk:8-alpine
FROM maven:3-adoptopenjdk
LABEL authors="QS"
LABEL maintainer="Comisiones"
WORKDIR /com-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
