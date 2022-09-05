package com.ecommerce.user.customer.repository;

import java.util.List;

import com.ecommerce.user.customer.model.Customer;

public interface CustomerRepository {

	Customer save(Customer customer);
	
	Customer findById(Long id);
	
	List<Customer> findAll();
	
	void update(Customer customer);
	
	void deleteAll();
	
	void delete(Long id);
}
