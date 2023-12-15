package com.crud.Crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.Crud.constants.ApiConstants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(RequestMappingConstants.PRODUCT_CONTROLLER)
public class ProductController {
	
	@GetMapping("/productdata")
	public ResponseEntity<?> getMethodName() {
		return ResponseEntity.ok("Woooo");
	}
	
}
