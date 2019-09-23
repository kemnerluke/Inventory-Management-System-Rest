package com.luv2code.InventoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.service.OrderHeaderService;

	

@RestController
@RequestMapping("/api")
public class OrderHeaderRestController {

	private OrderHeaderService OrderHeaderService;
	
	@Autowired
	public OrderHeaderRestController(OrderHeaderService theOrderHeaderService) {
		OrderHeaderService = theOrderHeaderService;
	}
	
	// expose "/OrderHeaders" and return list of OrderHeaders
	@GetMapping("/orderHeaders")
	public List<OrderHeader> findAll() {
		return OrderHeaderService.findAll();
	}

	// add mapping for GET /OrderHeaders/{OrderHeaderId}
	
	@GetMapping("/orderHeaders/{orderHeaderId}")
	public OrderHeader getOrderHeader(@PathVariable int OrderHeaderId) {
		
		OrderHeader theOrderHeader = OrderHeaderService.findById(OrderHeaderId);
		
		if (theOrderHeader == null) {
			throw new RuntimeException("OrderHeader id not found - " + OrderHeaderId);
		}
		
		return theOrderHeader;
	}
	
	// add mapping for POST /OrderHeaders - add new OrderHeader
	
	@PostMapping("/orderHeaders")
	public OrderHeader addOrderHeader(@RequestBody OrderHeader theOrderHeader) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theOrderHeader.setOrderHeaderId(0);
		
		OrderHeaderService.save(theOrderHeader);
		
		return theOrderHeader;
	}
	
	// add mapping for PUT /OrderHeaders - update existing OrderHeader
	
	@PutMapping("/orderHeaders")
	public OrderHeader updateOrderHeader(@RequestBody OrderHeader theOrderHeader) {
		
		OrderHeaderService.save(theOrderHeader);
		
		return theOrderHeader;
	}
	
	// add mapping for DELETE /OrderHeaders/{OrderHeaderId} - delete OrderHeader
	
	@DeleteMapping("/orderHeaders/{orderHeaderId}")
	public String deleteOrderHeader(@PathVariable int OrderHeaderId) {
		
		OrderHeader tempOrderHeader = OrderHeaderService.findById(OrderHeaderId);
		
		// throw exception if null
		
		if (tempOrderHeader == null) {
			throw new RuntimeException("OrderHeader id not found - " + OrderHeaderId);
		}
		
		OrderHeaderService.deleteById(OrderHeaderId);
		
		return "Deleted OrderHeader id - " + OrderHeaderId;
	}
	

}

