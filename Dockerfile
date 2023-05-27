FROM maven:3.9.1-amazoncorretto-19

WORKDIR /src

COPY . .

RUN mvn clean install -Dmaven.test.skip=true

CMD mvn spring-boot:run

