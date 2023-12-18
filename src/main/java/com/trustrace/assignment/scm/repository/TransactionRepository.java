package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String>{
    Transaction findByTransactionID(String transactionID);
}
