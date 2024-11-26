# Use the official maven image to build the application
# with OpenJDK 11
#FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
#WORKDIR /app

# Copy the pom.xml and source code into the container
#COPY pom.xml .
#COPY src ./src

# Package the application
#RUN mvn clean package -DskipTests

# Use the official OpenJDK image for running the application
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Install additional tools , just for dev purposes
RUN apk update && apk add --no-cache net-tools iputils

# Copy the packaged jar file into the container
COPY /target/service-b-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port 8080 to the outside world
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]