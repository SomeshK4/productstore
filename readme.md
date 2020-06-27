# Product Store Application
## Introduction
Application intended to demonstrate the use of Spring Boot,Spring REST, Java8, Maven, MapStruct, Embedded H2 Database with Docker and Docker compose file. 

## Prequisites
1. Maven
2. Java 8

### Steps to run the application
1. cd productstore
1. mvn clean install
2. docker build -t productstoreapplication .
3. docker run -d -p 8080:8080 productstoreapplication 

### Steps to run the application from command
1. cd productstore
2. mvn clean install
3. java -jar productstore-rest/target/productstore-rest-0.0.1-SNAPSHOT.jar

### Steps to run the application using Docker Compose
1. cd productstore
2. docker-compose up

## Example Endpoints for testing
1. GET http://localhost:8080/productstore/product?type=subscription&max_price=1000&city=Stockholm
2. GET http://localhost:8080/productstore/product?type=subscription&property=color
3. GET http://localhost:8080/productstore/product?type=subscription&property:color=purpur
4. GET http://localhost:8080/productstore/product?type=subscription&property:gb_limit_min=10


# Note: Make sure to use the property with colon (:) not with (.)


