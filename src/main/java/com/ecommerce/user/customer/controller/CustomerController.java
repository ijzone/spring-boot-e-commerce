package com.ecommerce.user.customer.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.ecommerce.user.UserLevel;
import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.customer.repository.CustomerRepository;
import com.ecommerce.user.customer.service.CustomerService;

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
		Customer customerA = new Customer("customerA", 23, 'M', true, "01011112222", null, "customerA@test.com", null, UserLevel.ONE);
		Customer customerB = new Customer("customerB", 36, 'F', false, "01033334444", null, "customerB@test.com", null, UserLevel.TWO);
		customerRepository.save(customerA);
		customerRepository.save(customerB);
	}
	
	@GetMapping
	public String customerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		return "/customer/list";
	}
	
	@GetMapping("/{id}")
	public String getCustomer(@PathVariable Long id, Model model) {
		Customer customer = customerService.findById(id);
		customer.setEditFalse();
		model.addAttribute("customer", customer);
		
		return "customer/view";
	}
	
	@PostMapping("/{id}")
	public String postCustomer(@PathVariable Long id, Model model) {
		Customer customer = new Customer("postCustomer", 20, 'M', true, null, null, null, null, UserLevel.FIVE);
		model.addAttribute("customer", customer);
		
		return ThymeleafViewResolver.REDIRECT_URL_PREFIX + "/customer/{id}";
	}
	
	@GetMapping("/edit/{id}")
	public String getEdit(@PathVariable Long id, Model model) {
		Customer customer = customerRepository.getCustomer(id);
		customer.setEditTrue();
		model.addAttribute("customer", customer);
		
		return "/customer/view";
	}
	
	@PostMapping("/edit/{id}")
	public String postEdit(@PathVariable Long id, @ModelAttribute Customer customer, Model model) {
		customer = customerRepository.edit(customer);
		model.addAttribute("customer", customer);
		
		return ThymeleafViewResolver.REDIRECT_URL_PREFIX + "/customer/{id}";
	}
}
