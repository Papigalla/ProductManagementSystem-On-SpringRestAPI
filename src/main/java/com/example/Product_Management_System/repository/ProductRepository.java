package com.example.Product_Management_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Product_Management_System.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
