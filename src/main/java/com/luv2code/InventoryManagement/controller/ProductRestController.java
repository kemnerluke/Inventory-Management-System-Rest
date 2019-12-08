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

import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	private ProductService productService;

	
	@Autowired
	public ProductRestController(ProductService theProductService) {
		productService = theProductService;
	}
	
	// expose "/Products" and return list of Products
	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}

	// add mapping for GET /Products/{ProductId}
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		
		Product theProduct = productService.findById(productId);
		
		if (theProduct == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		
		return theProduct;
	}
	
	// add mapping for POST /Products - add new Product
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProduct.setProductId(0);
		
		productService.save(theProduct);
		
		return theProduct;
	}
	
	// add mapping for PUT /Products - update existing Product
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product theProduct) {
		
		productService.save(theProduct);
		
		return theProduct;
	}
	
	// add mapping for DELETE /Products/{ProductId} - delete Product
	
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		
		Product tempProduct = productService.findById(productId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new RuntimeException("Product id not found - " + productId);
		}
		
		productService.deleteById(productId);
		
		return "Deleted Product id - " + productId;
	}
	
}
