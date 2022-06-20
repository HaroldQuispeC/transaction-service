package com.bootcamp.transactionservice.model.outcomeproduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
