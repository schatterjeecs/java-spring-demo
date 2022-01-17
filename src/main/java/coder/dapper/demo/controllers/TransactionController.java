package coder.dapper.demo.controllers;

import coder.dapper.demo.models.Transaction;
import coder.dapper.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transact/v1")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/allTransactions")
    public List<Transaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }

    @GetMapping(value = "/getTransactionById/{transactionId}")
    public Transaction getTransactionById(@PathVariable(value = "transactionId") Long transactionId) {
        System.out.println(transactionId);
        System.out.println(transactionService.findByTransactionId(transactionId));
        return transactionService.findByTransactionId(transactionId);
    }

    @PostMapping("/saveTransaction")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return transaction;
    }
}
