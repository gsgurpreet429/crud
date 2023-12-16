package com.crud.Crud.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Crud.entity.Product;
import com.crud.Crud.repository.ProductRepository;
import com.crud.Crud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> findProductById(long id) {
		return productRepository.findById(id);

	}

	@Override
	public Product saveProduct(Product productWithId) {
		return productRepository.save(productWithId);
	}
}
