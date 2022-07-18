package com.ecommerce.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductController(ProductService productService, ProductRepository productRepository) {
		this.productService = productService;
		this.productRepository = productRepository;
	}
	
	
}
