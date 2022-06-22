package com.bootcamp.transactionservice.repository;

import com.bootcamp.transactionservice.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
}
