package com.ecommerce.user.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.customer.repository.CustomerRepository;
import com.ecommerce.user.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
		this.customerService = customerService;
		this.customerRepository = customerRepository;
	}
	
//	@GetMapping
//	public String customerList(Model model) {
//		List<Customer> customers = customerService.findAll();
//		model.addAttribute("customers", customers);
//		
//		return "/customer/list";
//	}
	
	@GetMapping
	public String customer(Model model) {
		Customer customer = customerService.findById(1L);
		model.addAttribute("customer", customer);
		
		return "/customer/view";
	}
}
