package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.model.outcomeproduct.BankAccount;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@FeignClient(value = "client",
        url = "http://localhost:8083/api/outcomes")
public interface OutComeService {

  @GetMapping("/")
  public Flux<OutComeAccount> findAllOutCome();

  @GetMapping("/findAccountByDni/{dni}")
  public Mono<List<BankAccount>> getAccountsByDdni(@PathVariable("dni") String dni);

  @GetMapping("/findAccountByRuc/{ruc}")
  public Flux<BankAccount> getAccountsByRuc(@PathVariable("ruc") String ruc);

  @GetMapping("/findByAccountSerialNumber")
  public BankAccount findAccountByAccountSerialNumber(
          @RequestParam(value = "identifier", required = true) String identifier,
          @RequestParam(value = "accountSerialNumber", required = true) String accountSerialNumber);
}
