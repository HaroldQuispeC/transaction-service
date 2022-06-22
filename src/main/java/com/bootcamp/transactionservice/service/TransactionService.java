package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import reactor.core.publisher.Flux;

public interface TransactionService {

  Flux<OutComeAccount> getAccounts ();
}
