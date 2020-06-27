# Product Store Application
## Introduction
Application intended to demonstrate the use of following technologies to create a API to get the details of product from H2 Database.
- Spring Boot
- Spring REST
- Java8
- Maven
- MapStruct
- Embedded H2 Database
- Docker and Docker compose. 


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


