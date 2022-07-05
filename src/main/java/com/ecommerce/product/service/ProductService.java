package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.model.Product;

public interface ProductService {

	Product findById(Long id);
	
	Product findByName(String name);
	
	List<Product> findAll();
}
