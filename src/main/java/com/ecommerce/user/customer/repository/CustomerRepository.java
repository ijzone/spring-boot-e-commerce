package com.ecommerce.user.customer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ecommerce.user.customer.domain.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CustomerRepository {

	private static final Map<Long, Customer> store = new HashMap<>();
	private static long sequence = 0L;
	
	public Customer save(Customer customer) {
		customer.setId(++sequence);
		store.put(customer.getId(), customer);
		
		return customer;
	}
	
	public List<Customer> getList() {
		log.info("store: {}", store.values());
		return new ArrayList<>(store.values());
	}
	
	public Customer edit(Customer customer) {
		
		return customer;
	}
}