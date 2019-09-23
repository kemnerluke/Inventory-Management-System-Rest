package com.luv2code.InventoryManagement.service;

import java.util.List;

import com.luv2code.InventoryManagement.dto.OrderLineDTO;
import com.luv2code.InventoryManagement.entity.OrderLine;

public interface OrderLineService {

public List<OrderLine> findAll();
	
	public OrderLine findById(int theId);
	
	public void save(OrderLine theOrderLine);
	
	public void deleteById(int theId);
	
	
	
}
