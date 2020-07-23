FROM openjdk:8
EXPOSE 8080
MAINTAINER sreeragksreekumar1234@gmail.com
COPY target/*.jar  /home/app.jar
ENTRYPOINT ["java","-jar","/home/app.jar"]

