package com.ecommerce.product.model;

import java.math.BigDecimal;

import com.ecommerce.product.ProductType;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Product {

	@Setter
	private Long id;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	private ProductType productType;
}
