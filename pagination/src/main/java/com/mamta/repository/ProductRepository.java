package com.mamta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamta.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
