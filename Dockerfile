FROM openjdk:8
VOLUME /tmp
EXPOSE 8084
COPY ./target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar
ENTRYPOINT ["java", "-jar", "TransactionServiceApplication"]