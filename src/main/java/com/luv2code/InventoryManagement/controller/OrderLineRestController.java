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

import com.luv2code.InventoryManagement.entity.OrderLine;
import com.luv2code.InventoryManagement.service.OrderLineService;


	@RestController
	@RequestMapping("/api")
	public class OrderLineRestController {

		private OrderLineService OrderLineService;
		
		@Autowired
		public OrderLineRestController(OrderLineService theOrderLineService) {
			OrderLineService = theOrderLineService;
		}
		
		// expose "/OrderLines" and return list of OrderLines
		@GetMapping("/orderLines")
		public List<OrderLine> findAll() {
			return OrderLineService.findAll();
		}

		// add mapping for GET /OrderLines/{OrderLineId}
		
		@GetMapping("/orderLines/{orderLineId}")
		public OrderLine getOrderLine(@PathVariable int OrderLineId) {
			
			OrderLine theOrderLine = OrderLineService.findById(OrderLineId);
			
			if (theOrderLine == null) {
				throw new RuntimeException("OrderLine id not found - " + OrderLineId);
			}
			
			return theOrderLine;
		}
		
		// add mapping for POST /OrderLines - add new OrderLine
		
		@PostMapping("/orderLines")
		public OrderLine addOrderLine(@RequestBody OrderLine theOrderLine) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theOrderLine.setOrderLineId(0);
			
			OrderLineService.save(theOrderLine);
			
			return theOrderLine;
		}
		
		// add mapping for PUT /OrderLines - update existing OrderLine
		
		@PutMapping("/orderLines")
		public OrderLine updateOrderLine(@RequestBody OrderLine theOrderLine) {
			
			OrderLineService.save(theOrderLine);
			
			return theOrderLine;
		}
		
		// add mapping for DELETE /OrderLines/{OrderLineId} - delete OrderLine
		
		@DeleteMapping("/orderLines/{orderLineId}")
		public String deleteOrderLine(@PathVariable int OrderLineId) {
			
			OrderLine tempOrderLine = OrderLineService.findById(OrderLineId);
			
			// throw exception if null
			
			if (tempOrderLine == null) {
				throw new RuntimeException("OrderLine id not found - " + OrderLineId);
			}
			
			OrderLineService.deleteById(OrderLineId);
			
			return "Deleted OrderLine id - " + OrderLineId;
		}
		
}
