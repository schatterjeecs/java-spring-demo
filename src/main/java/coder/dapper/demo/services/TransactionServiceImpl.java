package coder.dapper.demo.services;

import coder.dapper.demo.models.Transaction;
import coder.dapper.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction findByTransactionId(Long transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
    }
}
