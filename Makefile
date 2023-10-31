

# create the container with postgres
compose-up-dev:
	docker-compose -f ./development-environment/docker-compose.yaml up

# destroy the container with postgres
compose-down-dev:
	docker-compose -f ./development-environment/docker-compose.yaml down

# Start the application locally using postgres docker database
start-dev-env: compose-down-dev compose-up-dev

## show log
log-local:
	docker-compose --file ./docker/local/docker-compose.yaml logs -f posterr-app