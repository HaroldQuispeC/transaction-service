package com.bootcamp.transactionservice.entity;

import lombok.Data;

/**
 * TransactionType.
 */
@Data
public class TransactionType {

  private String transactionTypeId;
  private String transactionName;
  private String transactionDescription;
}
