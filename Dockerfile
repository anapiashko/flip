FROM maven:3.6.1-jdk-8-alpine AS build

RUN apk update && \
    apk upgrade && \
    apk add --no-cache openssl

COPY . /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package -DskipTests

############################################################################

# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-alpine

RUN apk add --no-cache curl

# Create a group and user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# All future commands should run as the appuser user
USER appuser

# Setup working directory
WORKDIR /home/appuser

# Get the packed fat-JAR
COPY --from=build /usr/src/app/target/*.jar /home/appuser/app/app.jar

# Make app port available to the world outside this container
EXPOSE 8000

# JVM memory options
# ENV JAVA_TOOL_OPTIONS="-XX:+PrintFlagsFinal -XX:MaxRAM=1024m -XX:+UseG1GC -Xmx1g -Xms32m"

ENTRYPOINT ["java", "-jar","/home/appuser/app/app.jar"]
