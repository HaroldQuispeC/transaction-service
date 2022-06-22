package com.bootcamp.transactionservice.controller;

import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import com.bootcamp.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/transaction")
public class TransactionServiceController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String getSaludar(){

        return "Hola";
    }

    @GetMapping("/all")
    public Flux<OutComeAccount> getAllAccounts(){
        return transactionService.getAccounts();
    }
}
