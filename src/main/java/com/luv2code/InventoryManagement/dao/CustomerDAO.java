package com.luv2code.InventoryManagement.dao;

import java.util.List;

import com.luv2code.InventoryManagement.entity.Customer;
import com.luv2code.InventoryManagement.entity.Employee;

public interface CustomerDAO  {

public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
