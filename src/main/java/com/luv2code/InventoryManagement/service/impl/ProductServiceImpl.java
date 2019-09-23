package com.luv2code.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.InventoryManagement.dao.ProductDAO;
import com.luv2code.InventoryManagement.dto.ProductDTO;
import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.service.ProductService;
import com.luv2code.InventoryManagement.service.mapper.ProductMapper;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO ProductDAO;

	@Override
	@Transactional
	public List<Product> findAll() {
		return ProductDAO.findAll();
	}

	@Override
	@Transactional
	public Product findById(int theId) {
		return ProductDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Product theProduct) {
		ProductDAO.save(theProduct);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ProductDAO.deleteById(theId);
	}

	
	
}
