package com.ecommerce.user.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.customer.repository.CustomerRepositoryImpl;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepositoryImpl customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepositoryImpl customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer findByName(String name) {
		return null;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public boolean activateUser() {
		return false;
	}

	@Override
	public boolean deactivateUser() {
		return false;
	}

}
