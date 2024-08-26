# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the target directory to the working directory
COPY target/ReleaseNotes-0.0.1-SNAPSHOT.jar app.jar

# Expose port 9091 to the outside world
EXPOSE 9091

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optionally, you can specify the server port via an environment variable
ENV SERVER_PORT=9091
