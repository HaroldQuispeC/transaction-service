package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import reactor.core.publisher.Flux;

import java.util.List;

public interface TransactionService {

  List<OutComeAccount> getAccounts ();
}
