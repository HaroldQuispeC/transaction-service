package com.bootcamp.transactionservice.model.outcomeproduct;

import com.bootcamp.transactionservice.model.client.Client;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
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
