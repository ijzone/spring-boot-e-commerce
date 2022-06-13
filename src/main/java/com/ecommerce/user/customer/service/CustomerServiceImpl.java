package com.ecommerce.user.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.customer.domain.Customer;
import com.ecommerce.user.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer findById(Long id) {
		return customerRepository.getCustomer(id);
	}

	@Override
	public Customer findByName(String name) {
		return null;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.getList();
	}

}
