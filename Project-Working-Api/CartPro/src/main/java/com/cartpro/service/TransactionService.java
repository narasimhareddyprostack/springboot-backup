package com.cartpro.service;


import java.util.List;

import com.cartpro.model.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}