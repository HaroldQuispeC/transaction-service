package com.bootcamp.transactionservice.model.outcomeproduct;

import com.bootcamp.transactionservice.model.client.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Getter
@Setter
public class OutComeAccount {

  private String idOutComeAccount;
  private String startDate;
  private String endDate;
  private String identifier;
  private String status;
  private Client client;
  private ArrayList<BankAccount> bankAccounts;
}
