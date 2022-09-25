package com.cartpro.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cartpro.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}