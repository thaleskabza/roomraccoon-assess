# maven image 
FROM MAVEN:3.8.4-JDK-1

# creating a woking directory
WORKDIR /app

# copy dependencies 
COPY pom.xml .

# Copy the whole directory which holds the code: src/
COPY src ./src

RUN  mvn clean package -DskipTests


# Default maven test command
CMD ["mvn", " test"]
