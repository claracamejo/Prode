FROM openjdk:11
EXPOSE 8080
EXPOSE 5432
RUN mkdir -p /server/
WORKDIR /server/

COPY . /server/

RUN ./gradlew build -x test

ENTRYPOINT ["java", "-jar", "build/libs/prode-0.0.1-SNAPSHOT.jar"]