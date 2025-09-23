build:
	./mvnw -B -ntp clean package

run:
	./mvnw -B -ntp spring-boot:run

test:
	./mvnw -B -ntp test