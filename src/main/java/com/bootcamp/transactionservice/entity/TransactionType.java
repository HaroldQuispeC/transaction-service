package com.bootcamp.transactionservice.entity;

import lombok.Data;

@Data
public class TransactionType {

  private String transactionTypeId;
  private String transactionName;
  private String transactionDescription;
}
