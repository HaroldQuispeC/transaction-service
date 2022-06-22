package com.bootcamp.transactionservice.service.impl;

import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import com.bootcamp.transactionservice.service.OutComeService;
import com.bootcamp.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private OutComeService feingOutComeService;


  @Override
  public List<OutComeAccount> getAccounts() {
    return feingOutComeService.findAllOutCome();
  }
}
