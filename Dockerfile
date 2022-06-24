FROM openjdk:8
EXPOSE 8084
COPY "./target/transaction-service-0.0.1-SNAPSHOT.jar" "TransactionApplication"
ENTRYPOINT ["java", "-jar", "TransactionApplication"]