package com.bootcamp.transactionservice.entity;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Getter
@Setter
@Document(collection = "Transaction_Prueba")
public class Transaction {

  @Id
  private String accountTransactionId;
  private TransactionType transactionType;
  private LocalDateTime transactionDate;
  private String period;
  private Double amount;

}
