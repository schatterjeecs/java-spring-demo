package coder.dapper.demo;

import coder.dapper.demo.controllers.TransactionController;
import coder.dapper.demo.models.Transaction;
import coder.dapper.demo.repositories.TransactionRepository;
import coder.dapper.demo.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
public class MockMvcTransactionControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransactionRepository transactionRepository;

    @MockBean
    TransactionService transactionService;

    Transaction transaction1 = new Transaction(1L,
            "NewStore", 20,
            "2021-10-10");

    Transaction transaction2 = new Transaction(2L,
            "NewStore1", 10,
            "2021-10-10");

    @Test
    void getAllTransactionTestCtl() throws Exception {
        List<Transaction> transactions = new ArrayList<>(Arrays.asList(transaction1, transaction2));
        Mockito.when(transactionRepository.findByTransactionId(1L)).thenReturn(transaction1);

        System.out.println(mockMvc.perform(MockMvcRequestBuilders
                .get("/transact/v1/getTransactionById/1")
                .contentType(MediaType.APPLICATION_JSON)).andReturn());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/transact/v1/getTransactionById/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(transaction1.toString()))
        ;
    }

}
