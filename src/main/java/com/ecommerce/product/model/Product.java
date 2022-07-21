package com.ecommerce.product.model;

import com.ecommerce.product.ProductType;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Product {

	@Setter
	private Long id;
	
	private String name;
	private Long price;
	private int quantity;
	private ProductType productType;
}
