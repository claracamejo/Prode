# Prode

This project's goals is to create a World Cup 2022 prode for practice purposes

## Run it

### Pre requirements

Docker, Docker Compose, and Java 11 are required to run the project.

### Run

```shell
   docker-compose up -d
   ./gradlew bootRun
```
To run the front end you have to step on `.front/` and execute `npm start`

#### Run with Docker

To run with docker you have to build the images

```shell
    docker-compose build
```

And then run the images

```shell
    docker-compose up -d
```

Keep in mind that a change in application.yml is needed, you have to change:
```yaml
spring:
  datasource:
    url: 'jdbc:postgresql://localhost:5432/postgres'
```

to

```yaml
spring:
  datasource:
    url: 'jdbc:postgresql://postgres:5432/postgres'
```

Once it's up you are able to use the API.

## API Documentation

In progress...