package com.luv2code.InventoryManagement.service;


import java.util.List;

import com.luv2code.InventoryManagement.dto.CustomerDTO;
import com.luv2code.InventoryManagement.entity.Customer;

public interface CustomerService {

		

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
		
	}
