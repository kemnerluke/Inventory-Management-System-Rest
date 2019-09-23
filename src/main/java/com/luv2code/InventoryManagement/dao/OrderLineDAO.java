package com.luv2code.InventoryManagement.dao;

import java.util.List;

import org.hibernate.Session;

import com.luv2code.InventoryManagement.entity.OrderLine;

public interface OrderLineDAO {
	
public List<OrderLine> findAll();
	
	public OrderLine findById(int theId);
	
	public void save(OrderLine theOrderLine);
	
	public void deleteById(int theId);
}
