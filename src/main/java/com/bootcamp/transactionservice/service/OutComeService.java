package com.bootcamp.transactionservice.service;

import com.bootcamp.transactionservice.exceptions.ModelException;
import com.bootcamp.transactionservice.model.outcomeproduct.BankAccount;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import feign.Headers;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
  @CircuitBreaker(name = "outcome-product-service-cb")
  List<OutComeAccount> findAllOutCome();

  @PostMapping("/save")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public OutComeAccount saveOutAccount(OutComeAccount outComeAccount);

  @GetMapping("/getOutComeAccountByDni/{dni}")
  @Headers("Content-Type: application/json")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public OutComeAccount findOutComeAccountByDni(@PathVariable("dni") String dni);

  @GetMapping("/getOutComeAccountByRuc/{ruc}")
  @Headers("Content-Type: application/json")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public OutComeAccount findOutComeAccountByRuc(@PathVariable("ruc") String ruc);

  @GetMapping("/findAccountByDni/{dni}")
  @Headers("Content-Type: application/json")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public Mono<List<BankAccount>> getAccountsByDdni(@PathVariable("dni") String dni);

  @GetMapping("/findAccountByRuc/{ruc}")
  @Headers("Content-Type: application/json")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public List<BankAccount> getAccountsByRuc(@PathVariable("ruc") String ruc);

  @GetMapping("/findByAccountSerialNumber")
  @Headers("Content-Type: application/json")
  @CircuitBreaker(name = "outcome-product-service-cb")
  public BankAccount findAccountByAccountSerialNumber(
          @RequestParam(value = "identifier", required = true) String identifier,
          @RequestParam(value = "accountSerialNumber", required = true) String accountSerialNumber);

  /**
   * OutcomeProductServiceFallback.
   */
  @Component
  public class OutcomeProductServiceFallback implements OutComeService {

    private final String defaultMessage = "OutComeProductService is unavailable at this moment";

    // ------------------------------ OUTCOME PRODUCT - DEBITS ------------------------------

    @Override
    public List<OutComeAccount> findAllOutCome() {
      throw new ModelException(String.format("findAll: %s", defaultMessage));
    }

    @Override
    public OutComeAccount saveOutAccount(OutComeAccount outComeAccount) {
      throw new ModelException(String.format("saveOutAccount: %s", defaultMessage));
    }

    @Override
    public OutComeAccount findOutComeAccountByDni(@PathVariable("dni") String dni) {
      throw new ModelException(String.format("findOutComeAccountByDni: %s", defaultMessage));
    }

    @Override
    public OutComeAccount findOutComeAccountByRuc(@PathVariable("ruc") String ruc) {
      throw new ModelException(String.format("findOutComeAccountByRuc: %s", defaultMessage));
    }

    @Override
    public Mono<List<BankAccount>> getAccountsByDdni(@PathVariable("dni") String dni) {
      throw new ModelException(String.format("getAccountsByDdni: %s", defaultMessage));
    }

    @Override
    public List<BankAccount> getAccountsByRuc(@PathVariable("ruc") String ruc) {
      throw new ModelException(String.format("getAccountsByRuc: %s", defaultMessage));
    }

    @Override
    public BankAccount findAccountByAccountSerialNumber(
            @RequestParam(value = "identifier", required = true) String identifier,
            @RequestParam(value = "accountSerialNumber", required = true)
                    String accountSerialNumber) {
      throw new ModelException(String.format("findAccountByAccountSerialNumber: %s",
              defaultMessage));
    }
  }

}
