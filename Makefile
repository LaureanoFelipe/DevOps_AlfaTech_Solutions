build:
	mvn clean
	mvn package

run:
	mvn spring-boot:run

test:
	mvn test

verify:
	mvn verify

c_build:
	docker build -t felipelaureano/devops_alfatech_solutions .

c_run_it: c_build
	docker run -it felipelaureano/devops_alfatech_solutions /bin/bash

c_run:
	docker run -d -p 8080:8080 \
	-e MENSAGEM=Demonstração \
	felipelaureano/devops_alfatech_solutions