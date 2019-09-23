package com.luv2code.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.InventoryManagement.dao.CustomerDAO;
import com.luv2code.InventoryManagement.dao.EmployeeDAO;
import com.luv2code.InventoryManagement.dto.CustomerDTO;
import com.luv2code.InventoryManagement.entity.Customer;
import com.luv2code.InventoryManagement.entity.Employee;
import com.luv2code.InventoryManagement.service.CustomerService;
import com.luv2code.InventoryManagement.service.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}


}