package com.ecommerce.user.customer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.ecommerce.user.customer.model.Customer;

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
	
	public Customer getCustomer(Long id) {
		return store.get(id);
	}
	
	public Customer getCustomerByName(String name) {
		if(!store.isEmpty()) {
			for(Entry<Long, Customer> customer: store.entrySet()) {
				if(customer.getValue().getFirstName().equals(name)) {
					return customer.getValue();
				}
			}
		}
		
		return null;
	}
	
	public Customer edit(Customer customer) {
		store.put(customer.getId(), customer);
		return customer;
	}
	
	public void delete(Customer customer) {
		store.remove(customer.getId());
	}
	
	public void deleteAll() {
		store.clear();
	}
}
