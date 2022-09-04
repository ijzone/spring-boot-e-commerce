package com.ecommerce.user.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping
	public String customerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		return "/customer/list";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		return "/customer/sign-up";
	}
	
	@PostMapping("/sign-up")
	public String signUp(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
		Customer savedCustomer = customerService.save(customer);
		redirectAttributes.addAttribute("id", savedCustomer.getId());
		
		return "redirect:/customer/{id}";
	}
	
	@GetMapping("/{id}")
	public String customer(Model model, @PathVariable Long id, @RequestParam(defaultValue = "false", name = "edit") Boolean edit) {
		Customer customer = customerService.findById(id);
		if(edit == true) {
			customer.setEditTrue();
		}
		model.addAttribute("customer", customer);
		
		return "/customer/view";
	}
	
	@PostMapping("/{id}")
	public String customer(Model model, @PathVariable Long id, @ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
		customerService.update(customer);
		redirectAttributes.addAttribute("id", id);
		
		return "redirect:/customer/{id}";
	}
	
	@DeleteMapping("/{id}")
	public String customer(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
		log.info("Delete ID: {}", id);
		customerService.deleteAll();
		
		return "redirect:/customer";
	}
}
