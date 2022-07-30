package com.ecommerce.product.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.product.model.Product;

@SpringBootTest
class ProductRepositoryTest {

	@Autowired private ProductRepository productRepository;
	
	@PostConstruct
	void data() {
		productRepository.save(new Product(1L, "productA", 1000L, 1, Product.Category.ACCESSORIES, Product.Status.ORDERED));
		productRepository.save(new Product(2L, "productB", 2000L, 1, Product.Category.ELECTRONICS, Product.Status.CANCELED));
		productRepository.save(new Product(3L, "productC", 4000L, 1, Product.Category.FASHION, Product.Status.PAID));
		productRepository.save(new Product(4L, "productD", 6000L, 1, Product.Category.FOOD, Product.Status.PENDING));
		productRepository.save(new Product(5L, "productE", 7000L, 1, Product.Category.ACCESSORIES, Product.Status.COMPLETE));
	}
	
	@Test
	void findProductTest() {
		// given
		String name = "productA";
		
		// when
		Product product2 = productRepository.getProduct(2L);
		// then
		assertThat(product2.getName()).isEqualTo("productB");
		
		// when
		Product product = productRepository.getProduct(name);
		// then
		assertThat(product.getName()).isEqualTo("productA");

		// when
		int productSize = productRepository.getList().size();
		// then
		assertThat(productSize).isEqualTo(5);
	}
	
	@Test
	void removeProductTest() {
		// given
		Long id = 2L;
		
		// when
		productRepository.delete(id);
		
		// then
		List<Product> list = productRepository.getList();
		list.stream().forEach(product -> System.out.println(product.getName()));
		long count = list.stream().count();
		assertThat(count).isEqualTo(4L);
	}

}
