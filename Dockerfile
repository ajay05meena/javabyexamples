FROM openjdk:8-jdk-alpine

ADD app/build/libs/app.jar app.jar

ADD app/src/main/resources/app.yaml app.yaml

CMD java -jar app.jar server app.yaml 

EXPOSE 8080
