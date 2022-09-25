package com.cartpro.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cartpro.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}