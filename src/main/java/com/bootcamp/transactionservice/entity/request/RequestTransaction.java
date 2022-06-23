package com.bootcamp.transactionservice.entity.request;

import com.bootcamp.transactionservice.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RequestTransaction.
 */
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestTransaction {

  private TransactionType transactionType;
  private String identifier;
  private String accountSerialNumber;
  private Double amount;
}
