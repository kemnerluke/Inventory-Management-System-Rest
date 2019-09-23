package com.luv2code.InventoryManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luv2code.InventoryManagement.dao.OrderHeaderDAO;
import com.luv2code.InventoryManagement.dao.OrderHeaderDAO;
import com.luv2code.InventoryManagement.dao.OrderHeaderDAO;
import com.luv2code.InventoryManagement.dao.OrderLineDAO;
import com.luv2code.InventoryManagement.dao.ProductDAO;
import com.luv2code.InventoryManagement.dto.OrderHeaderDTO;
import com.luv2code.InventoryManagement.dto.OrderLineDTO;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderLine;
import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.service.OrderHeaderService;
import com.luv2code.InventoryManagement.service.mapper.OrderHeaderMapper;
import com.luv2code.InventoryManagement.service.mapper.OrderLineMapper;

@Service
@Transactional
public class OrderHeaderServiceImpl implements OrderHeaderService {

	@Autowired
	private OrderHeaderDAO orderHeaderDAO;

	@Override
	@Transactional
	public List<OrderHeader> findAll() {
		return orderHeaderDAO.findAll();
	}

	@Override
	@Transactional
	public OrderHeader findById(int theId) {
		return orderHeaderDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(OrderHeader theOrderHeader) {
		orderHeaderDAO.save(theOrderHeader);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		orderHeaderDAO.deleteById(theId);
	}
}
