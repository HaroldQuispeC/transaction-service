package com.bootcamp.transactionservice.model.outcomeproduct;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BankAccount.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccount {

  private OutComeAccountType outComeAccountType;
  private Double currentBalance;
  private String status;
  private String accountSerialNumber;
  private DebitCard debitCard;
  private ArrayList<BankAccountOwner> bankAccountOwners;
  private ArrayList<BankAccountSigner> bankAccountSigners;
}
