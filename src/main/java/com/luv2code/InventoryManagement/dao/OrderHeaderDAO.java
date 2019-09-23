package com.luv2code.InventoryManagement.dao;


import java.util.List;

import com.luv2code.InventoryManagement.entity.OrderHeader;

public interface OrderHeaderDAO {

	public List<OrderHeader> findAll();
	
	public OrderHeader findById(int theId);
	
	public void save(OrderHeader theOrderHeader);
	
	public void deleteById(int theId);
}
