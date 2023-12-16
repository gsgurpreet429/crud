package com.crud.Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Crud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
