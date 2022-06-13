package com.ecommerce.user.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.user.customer.domain.Customer;
import com.ecommerce.user.customer.repository.CustomerRepository;
import com.ecommerce.user.customer.service.CustomerService;
import com.ecommerce.user.domain.Level;

//@RequiredArgsConstructor
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
	
	@PostConstruct
	public void init() {
		Customer customerA = new Customer("customerA", 23, 'M', true, "01011112222", null, null, null, Level.ONE);
		Customer customerB = new Customer("customerB", 36, 'F', false, "01033334444", null, null, null, Level.TWO);
		customerRepository.save(customerA);
		customerRepository.save(customerB);
	}
	
	@GetMapping
	public String customerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "/customer/list";
	}
}
