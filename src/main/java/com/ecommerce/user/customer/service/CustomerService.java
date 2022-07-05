package com.ecommerce.user.customer.service;

import java.util.List;

import com.ecommerce.user.customer.model.Customer;

public interface CustomerService {

	Customer findById(Long id);
	
	Customer findByName(String name);
	
	List<Customer> findAll();
}
