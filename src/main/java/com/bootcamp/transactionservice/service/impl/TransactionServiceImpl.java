package com.bootcamp.transactionservice.service.impl;

import com.bootcamp.transactionservice.entity.Transaction;
import com.bootcamp.transactionservice.entity.request.RequestTransaction;
import com.bootcamp.transactionservice.model.outcomeproduct.BankAccount;
import com.bootcamp.transactionservice.model.outcomeproduct.OutComeAccount;
import com.bootcamp.transactionservice.service.OutComeService;
import com.bootcamp.transactionservice.service.TransactionService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * TransactionServiceImpl.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

  private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

  @Autowired
  private OutComeService feingOutComeService;

  @Override
  public List<OutComeAccount> getAccounts() {
    return feingOutComeService.findAllOutCome();
  }

  @Override
  public Mono<Transaction> deposit(RequestTransaction requestTransaction) {
    String identifier = requestTransaction.getIdentifier();
    String accountSerialNumber = requestTransaction.getAccountSerialNumber();

    Transaction transaction = new Transaction();

    transaction.setTransactionType(requestTransaction.getTransactionType());
    transaction.setTransactionDate(getTimeNow());
    transaction.setAccountSerialNumber(accountSerialNumber);

    OutComeAccount outComeAccount = feingOutComeService.findOutComeAccountByDni(identifier);
    transaction.setNameClient(outComeAccount.getClient().getNaturalPerson().getName());
    transaction.setAmount(requestTransaction.getAmount());
    BankAccount bankAccount = feingOutComeService
            .findAccountByAccountSerialNumber(identifier, accountSerialNumber);
    bankAccount.setCurrentBalance(calculateBalanceDeposit(bankAccount,
            requestTransaction.getAmount()));
    ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    bankAccounts.add(bankAccount);

    outComeAccount.setBankAccounts(bankAccounts);
    feingOutComeService.saveOutAccount(outComeAccount);

    return Mono.just(transaction);
  }

  @Override
  public Mono<Transaction> movements(RequestTransaction requestTransaction) {

    String compare = requestTransaction.getTransactionType().getTransactionTypeId();
    String identifier = requestTransaction.getIdentifier();
    String accountSerialNumber = requestTransaction.getAccountSerialNumber();
    Transaction transaction = new Transaction();

    if (compare.equals("1")) {

      transaction = setValues(requestTransaction);

      OutComeAccount outComeAccount = feingOutComeService.findOutComeAccountByDni(identifier);

      transaction.setNameClient(getFullName(outComeAccount));

      BankAccount bankAccount = feingOutComeService
              .findAccountByAccountSerialNumber(identifier, accountSerialNumber);

      bankAccount.setCurrentBalance(calculateBalanceDeposit(bankAccount,
              requestTransaction.getAmount()));

      ArrayList<BankAccount> bankAccounts = new ArrayList<>();
      bankAccounts.add(bankAccount);

      outComeAccount.setBankAccounts(bankAccounts);
      feingOutComeService.saveOutAccount(outComeAccount);

    } else if (compare.equals("2")) {
      transaction = setValues(requestTransaction);
      OutComeAccount outComeAccount = feingOutComeService.findOutComeAccountByDni(identifier);

      transaction.setNameClient(getFullName(outComeAccount));

      BankAccount bankAccount = feingOutComeService
              .findAccountByAccountSerialNumber(identifier, accountSerialNumber);

      bankAccount.setCurrentBalance(calculateBalanceWithdrawal(
              bankAccount, requestTransaction.getAmount()));

      ArrayList<BankAccount> bankAccounts = new ArrayList<>();
      bankAccounts.add(bankAccount);

      outComeAccount.setBankAccounts(bankAccounts);
      feingOutComeService.saveOutAccount(outComeAccount);

    } else if (compare.equals("3")) {
      return null;
    }

    return Mono.just(transaction);
  }

  /**
   * setValues.
   *
   * @param requestTransaction RequestTransaction
   * @return Transaction
   */
  public Transaction setValues(RequestTransaction requestTransaction) {
    Transaction transaction = new Transaction();
    transaction.setTransactionType(requestTransaction.getTransactionType());
    transaction.setTransactionDate(getTimeNow());
    transaction.setAccountSerialNumber(requestTransaction.getAccountSerialNumber());
    transaction.setAmount(requestTransaction.getAmount());

    return transaction;
  }

  /**
   * getFullName.
   *
   * @param outComeAccount OutComeAccount
   * @return String
   */
  public String getFullName(OutComeAccount outComeAccount) {
    String name = outComeAccount.getClient().getNaturalPerson().getName();
    String lastName = outComeAccount.getClient().getNaturalPerson().getLastName();

    String fullName = name.concat(" ").concat(lastName);
    return fullName;
  }

  /**
   * getTimeNow.
   *
   * @return String
   */
  public String getTimeNow() {
    LocalDateTime dt = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    String response = dtf.format(dt).toString();
    return response;
  }

  public Double calculateBalanceDeposit(BankAccount bankAccount, Double amount) {
    double balance = bankAccount.getCurrentBalance() + amount;
    return balance;
  }

  /**
   * calculateBalanceWithdrawal.
   *
   * @param bankAccount BankAccount
   * @param amount Double
   * @return Double
   */
  public Double calculateBalanceWithdrawal(BankAccount bankAccount, Double amount) {
    double balance = bankAccount.getCurrentBalance() - amount;
    if (balance < 0) {
      logger.info("The amount to withdraw is greater than the balance");
    } else {
      logger.info("The balance is greater than withdrawal");
    }
    return balance;
  }
}
