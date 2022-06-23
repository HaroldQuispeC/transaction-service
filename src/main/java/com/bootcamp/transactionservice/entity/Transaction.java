package com.bootcamp.transactionservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Transaction.
 */
@Data
@Getter
@Setter
@Document(collection = "Transaction_Prueba")
public class Transaction {

  @Id
  private String accountTransactionId;
  private TransactionType transactionType;
  private String transactionDate;
  private String accountSerialNumber;
  private String nameClient;
  private Double amount;

}
