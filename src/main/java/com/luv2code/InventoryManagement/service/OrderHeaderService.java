package com.luv2code.InventoryManagement.service;

import java.util.List;

import com.luv2code.InventoryManagement.dto.OrderHeaderDTO;
import com.luv2code.InventoryManagement.entity.OrderHeader;

public interface OrderHeaderService {


	public List<OrderHeader> findAll();
	
	public OrderHeader findById(int theId);
	
	public void save(OrderHeader theOrderHeader);
	
	public void deleteById(int theId);
	
	

}