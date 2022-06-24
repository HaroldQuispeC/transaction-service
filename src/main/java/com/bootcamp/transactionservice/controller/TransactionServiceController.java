package com.bootcamp.transactionservice.controller;

import com.bootcamp.transactionservice.entity.Transaction;
import com.bootcamp.transactionservice.entity.request.RequestTransaction;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import com.bootcamp.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TransactionServiceController.
 */
@RestController
@RequestMapping("/api/transaction")
public class TransactionServiceController {

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/all")
  public Flux<OutComeAccount> getAllAccounts() {

    return Flux.fromIterable(transactionService.getAccounts());
  }

  @PostMapping("/movementsBusinessAccounts")
  public Mono<Transaction> deposit(@RequestBody RequestTransaction requestTransaction) {
    return transactionService.movementsBusiness(requestTransaction);
  }

  @PostMapping("/movements")
  public Mono<Transaction> movements(@RequestBody RequestTransaction requestTransaction) {
    return transactionService.movements(requestTransaction);
  }

}
