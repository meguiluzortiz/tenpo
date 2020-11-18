clean-verify:
	./mvnw clean verify

clean-verify-notests:
	./mvnw -DskipTests clean verify
	
run:
	./mvnw spring-boot:run
	
run-debug:
	./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000"

docker-build:
	docker build -t meguiluzortiz/tenpo .

docker-push:
	docker push meguiluzortiz/tenpo

docker-publish:
	make clean-verify-notests && make docker-build && make docker-push

docker-compose-up:
	docker-compose up

docker-compose-upd:
	docker-compose up -d

docker-compose-up-app:
	docker-compose up app

docker-compose-up-db:
	docker-compose up db

docker-compose-down:
	docker-compose down