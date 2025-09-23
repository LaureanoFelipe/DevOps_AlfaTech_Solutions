build: 
	mvn clean
	mvn package

run:
	mvn spring-boot:run

test:
	mvn test