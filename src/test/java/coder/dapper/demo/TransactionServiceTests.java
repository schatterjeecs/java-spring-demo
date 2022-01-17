package coder.dapper.demo;

import coder.dapper.demo.models.Transaction;
import coder.dapper.demo.repositories.TransactionRepository;
import coder.dapper.demo.services.TransactionService;
import coder.dapper.demo.services.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceTests {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService = new TransactionServiceImpl();

    @BeforeEach
    void mockTransaction() {
        when(transactionRepository.findByTransactionId(1L)).thenReturn(
                new Transaction(1L, "NewStore", 20, "2021-10-10")
        );
    }

    @Test
    void testGetAllTransactions() {
        Transaction sampleData = new Transaction(1L,
                "NewStore", 20, "2021-10-10");
        System.out.println(transactionService.findByTransactionId(1L).getTransactionDate());
        assertEquals(sampleData.getTransactionDate(),
                transactionService.findByTransactionId(1L).getTransactionDate());
    }
}

