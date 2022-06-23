package com.bootcamp.transactionservice.model.outcomeproduct;

import com.bootcamp.transactionservice.model.client.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * BankAccountSigner.
 */
@Data
@Getter
@Setter
public class BankAccountSigner {

  private String status;
  private Client client;
}
