# car-organizer
This is a spring boot application for the car organizer.

# Implementation  
Below technologies or concepts are used

1. Spring boot
2. Java
3. Spring
4. Hibernate/JPA
5. Rest concepts
6. H2 database
7. Spring security

#pre requisite software

1. mvn
2. java 8

# Deployment
run the below commands in the car-organizer-service folder.

mvn install (This will build the entire project and run the unit tests).
mvn spring-boot:run (This will run the service at localhost:8080).

# security (bonus)

Basic authentication mechanism is configured via spring security and hence to invoke any endpoint the user has to
be authenticated.

So all the endpoints are secured.

# manual testing
when the service is run the data.sql in main/resources folder will insert the data into the table.

Then we can use the postman or curl to invoke few endpoints to manual test.

please see the controller classes to find the which endpoints we can invoke

for example

invoke 

curl --user admin:password http://localhost:8080/manufacturer/1

will give the overview of all the models and features available for BMW( id 1)

#unit tests
I have written few tests cases for service ans controller class but not for all.
Did not cover 100 percent code coverage but written few test cases to give the idea.
Normally in production application i always try to cover 100 percent code coverage.


#database

H2 inmemory database is used.
Once the application is run we can go to the 
http://localhost:8080/h2-console/

we can see the tables and data.




