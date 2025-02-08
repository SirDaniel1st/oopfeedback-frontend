# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/src/app

# Create a non-root user for security
RUN useradd -ms /bin/bash sandboxuser
USER sandboxuser

# Copy all project files (Docker will mount the actual files later)
COPY . .

# Command to compile and run Java files
CMD ["sh", "-c", "javac -cp itextpdf-5.5.6.jar *.java && java -cp itextpdf-5.5.6.jar:. LabTestsRunner"]
