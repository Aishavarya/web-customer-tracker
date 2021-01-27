package com.ash.springdemo.dao;

import java.util.List;

import com.ash.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer); 

}
