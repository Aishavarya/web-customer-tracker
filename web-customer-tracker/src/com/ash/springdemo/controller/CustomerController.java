package com.ash.springdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ash.springdemo.dao.CustomerDAO;
import com.ash.springdemo.entity.Customer;
import com.ash.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get the customers from the service
		
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customers to the model
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer", theCustomer); 
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showForForUpdate(@RequestParam("customerId") int id, Model theModel) {
		
		Customer theCustomer=customerService.getCustomer(id);
		
		theModel.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
	
	
}
