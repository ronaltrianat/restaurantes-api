FROM java:8-jdk-alpine
COPY ./build/libs/restaurants-api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "restaurants-api-0.0.1-SNAPSHOT.jar"]