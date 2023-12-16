package com.crud.Crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.Crud.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();

	Product save(Product product);

	Optional<Product> findProductById(long id);

	Product saveProduct(Product productWithId);

}
