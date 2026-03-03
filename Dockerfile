# Use official lightweight Java image
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy all project files into container
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the project (skip tests for faster deploy)
RUN ./mvnw clean package -DskipTests

# Expose port (Render will inject dynamic PORT)
EXPOSE 8080

# Run the generated jar file
CMD ["java", "-jar", "target/github-analyzer-0.0.1-SNAPSHOT.jar"]