package com.ecommerce.product.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProductRepository {

	private static final Map<Long, Product> store = new HashMap<>();
	private static Long id = 0L;
	
	public Product save(Product product) {
		product.setProductId(++id);
		store.put(id, product);
		return product;
	}
	
	public List<Product> getList() {
		log.info("store: {}", store.values());
		return new ArrayList<Product>(store.values());
	}
	
	public Product getProduct(Long id) {
		return store.get(id);
	}
	
	public Product edit(Product product) {
		store.put(product.getProductId(), product);
		return product;
	}
	
	public void delete(Product product) {
		store.remove(product.getProductId());
	}
	
	public void deleteAll() {
		store.clear();
	}
}
