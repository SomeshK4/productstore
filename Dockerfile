FROM openjdk:8-jdk-alpine

#maintainer 
MAINTAINER someshk4@gmail.com

Volume /tmp

#expose port 8080
EXPOSE 8080

ADD productstore-rest/target/productstore-rest-0.0.1-SNAPSHOT.jar productstore-rest-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/productstore-rest-0.0.1-SNAPSHOT.jar"]