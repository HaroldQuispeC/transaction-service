package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.model.outcomeproduct.BankAccount;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import feign.Headers;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;


/**
 * OutComeService.
 */
@FeignClient(name = "GATEWAY-SERVICE/api/outcomes")
public interface OutComeService {

  @GetMapping("/")
  @Headers("Content-Type: application/json")
  List<OutComeAccount> findAllOutCome();

  @PostMapping("/save")
  public OutComeAccount saveOutAccount(OutComeAccount outComeAccount);

  @GetMapping("/getOutComeAccountByDni/{dni}")
  @Headers("Content-Type: application/json")
  public OutComeAccount findOutComeAccountByDni(@PathVariable("dni") String dni);

  @GetMapping("/getOutComeAccountByRuc/{ruc}")
  @Headers("Content-Type: application/json")
  public OutComeAccount findOutComeAccountByRuc(@PathVariable("ruc") String ruc);

  @GetMapping("/findAccountByDni/{dni}")
  @Headers("Content-Type: application/json")
  public Mono<List<BankAccount>> getAccountsByDdni(@PathVariable("dni") String dni);

  @GetMapping("/findAccountByRuc/{ruc}")
  @Headers("Content-Type: application/json")
  public List<BankAccount> getAccountsByRuc(@PathVariable("ruc") String ruc);

  @GetMapping("/findByAccountSerialNumber")
  @Headers("Content-Type: application/json")
  public BankAccount findAccountByAccountSerialNumber(
          @RequestParam(value = "identifier", required = true) String identifier,
          @RequestParam(value = "accountSerialNumber", required = true) String accountSerialNumber);
}
