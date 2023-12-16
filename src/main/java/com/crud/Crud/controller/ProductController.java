package com.crud.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Crud.constants.ApiConstants.RequestMappingConstants;
import com.crud.Crud.entity.Product;
import com.crud.Crud.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(RequestMappingConstants.PRODUCT_CONTROLLER)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Operation(summary = "Get all products", description = "Returns all products")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The products were not found")
	    })
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Get product by id", description = "Returns product by id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
	    })
	@GetMapping("/findproductid")
	public ResponseEntity<Product> getProductById(@RequestParam(name = "productId") long id) {
		return productService.findProductById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity
						.notFound().build());
		}
	
	
	@Operation(summary = "Save a product by id", description = "Saves a product as per the id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully saved"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The product was not saved")
	    })
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "Update a product by id", description = "Updates a product as per the id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully updates"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The product was not updated")
	    })
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId") long id, @RequestBody Product product){
		return productService.findProductById(id)
		.map(productObj -> {
			Product productWithId = product.toBuilder().productId(product.getProductId()).build();
			return ResponseEntity.ok(productService.saveProduct(productWithId));
		}).orElseGet(() -> ResponseEntity
						.notFound().build());
	}
	
	@Operation(summary = "Delete a product by id", description = "Delete a product as per the id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully Deletd"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
	    })
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") Long id){
		return productService.findProductById(id)
		.map(product -> {
			productService.deleteById(id);
			return ResponseEntity.ok(product);
		}).orElseGet(() -> ResponseEntity
						.notFound().build());
	}
}
