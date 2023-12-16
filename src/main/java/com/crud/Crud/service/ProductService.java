package com.crud.Crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.Crud.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();

	Product save(Product product);

	Optional<Product> findProductById(Long id);

	Product saveProduct(Product productWithId);

	void deleteById(Long id);

}
