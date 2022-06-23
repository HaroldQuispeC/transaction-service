package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.entity.Transaction;
import com.bootcamp.transactionservice.entity.request.RequestTransaction;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * TransactionService.
 */
public interface TransactionService {

  List<OutComeAccount> getAccounts();

  Mono<Transaction> deposit(RequestTransaction requestTransaction);

  Mono<Transaction> movements(RequestTransaction requestTransaction);
}
