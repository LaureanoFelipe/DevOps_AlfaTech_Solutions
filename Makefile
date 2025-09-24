build:
	./mvnw -B -ntp clean package || mvn -B -ntp cl

run:
	./mvnw -B -ntp spring-boot:run

test:
	./mvnw -B -ntp test || mvn -B -ntp test