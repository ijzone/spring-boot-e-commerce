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

import com.ecommerce.user.customer.model.Customer;
import com.ecommerce.user.customer.repository.CustomerRepository;
import com.ecommerce.user.customer.service.CustomerService;
import com.ecommerce.user.model.User;

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
		Customer customerA = new Customer("initA", "lastA", 23, 'M', "01011112222", null, "initA@test.com", null, null, null, null, User.Level.ONE, true, false);
		Customer customerB = new Customer("initB", "lastB", 36, 'F', "01033334444", null, "initB@test.com", null, null, null, null, User.Level.TWO, false, false);
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
		
		return "/customer/view";
	}
	
	@PostMapping("/{id}")
	public String postCustomer(@PathVariable Long id, Model model) {
		Customer customer = new Customer("postCustomer", "postLast", 20, 'M', null, null, null, null, null, null, null, User.Level.FIVE, true, false);
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
