package com.luv2code.InventoryManagement.service;

import java.util.List;

import com.luv2code.InventoryManagement.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);

}
