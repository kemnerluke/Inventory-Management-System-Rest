package com.luv2code.InventoryManagement.dao;

import java.util.List;

import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.entity.Product;

public interface ProductDAO {
	
public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);

}
