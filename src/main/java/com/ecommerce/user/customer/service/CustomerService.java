package com.ecommerce.user.customer.service;

import java.util.List;

import com.ecommerce.user.customer.model.Customer;

public interface CustomerService {

	Customer save(Customer customer);
	
	Customer findById(Long id);
	
	Customer findByName(String name);
	
	List<Customer> findAll();
	
	boolean activateUser();
	
	boolean deactivateUser();
	
	void update(Customer customer);
}
