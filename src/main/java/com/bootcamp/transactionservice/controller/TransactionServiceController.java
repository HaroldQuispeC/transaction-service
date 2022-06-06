package com.bootcamp.transactionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionServiceController {

    @GetMapping("/")
    public String getSaludar(){

        return "Hola";
    }
}