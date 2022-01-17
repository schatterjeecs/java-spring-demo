package coder.dapper.demo.services;

import coder.dapper.demo.models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransaction();

    void saveTransaction(Transaction transaction);

    Transaction findByTransactionId(Long transactionId);
}
