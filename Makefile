# Variables por defecto
SERVICE=
CONTEXT=

# Comandos principales

.PHONY: help create-bc db-up db-down build run-service

help:
	@echo "Tablease Monorepo - Comandos disponibles:"
	@echo "make create-bc SERVICE=service-name [CONTEXT=context-name]   		- Crea la estructura de un bounded context"
	@echo "make db-up                        									- Levanta las bases de datos con Docker Compose"
	@echo "make db-down                      									- Apaga las bases de datos y elimina volúmenes"
	@echo "make build                        									- Compila todos los servicios (mvn clean install)"
	@echo "make run-service SERVICE=service-name 								- Ejecuta un servicio concreto con Spring Boot"

create-bc:
	bash scripts/create-bc.sh $(SERVICE) $(CONTEXT)

db-up:
	docker-compose -f infra/docker-compose.yml up -d

db-down:
	docker-compose -f infra/docker-compose.yml down 

build:
	mvn clean install -DskipTests

run-service:
	@echo "Ejecutando $(SERVICE)..."
	cd services/$(SERVICE) && mvn spring-boot:run 
