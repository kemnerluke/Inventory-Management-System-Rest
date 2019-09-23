package com.luv2code.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.InventoryManagement.dao.OrderLineDAO;
import com.luv2code.InventoryManagement.dao.OrderLineDAO;
import com.luv2code.InventoryManagement.dto.OrderLineDTO;
import com.luv2code.InventoryManagement.entity.OrderLine;
import com.luv2code.InventoryManagement.entity.OrderLine;
import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.service.OrderLineService;
import com.luv2code.InventoryManagement.service.mapper.OrderLineMapper;

@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {

	@Autowired
	private OrderLineDAO orderLineDAO;

	@Override
	@Transactional
	public List<OrderLine> findAll() {
		return orderLineDAO.findAll();
	}

	@Override
	@Transactional
	public OrderLine findById(int theId) {
		return orderLineDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(OrderLine theOrderLine) {
		orderLineDAO.save(theOrderLine);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		orderLineDAO.deleteById(theId);
	}

}
