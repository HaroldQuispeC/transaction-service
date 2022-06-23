package com.bootcamp.transactionservice.model.outcomeproduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DebitCard.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DebitCard {

  private String debitCardId;
  private String financialCompany;
  private String creditCardSn;
  private String expirationDate;
  private String cvv;
  private String status;
}
