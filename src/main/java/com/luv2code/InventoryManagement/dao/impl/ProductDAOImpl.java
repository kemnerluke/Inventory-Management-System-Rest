package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.InventoryManagement.dao.ProductDAO;
import com.luv2code.InventoryManagement.entity.Product;
import com.luv2code.InventoryManagement.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Product> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Product> theQuery =
				currentSession.createQuery("from Product", Product.class);
		
		// execute query and get result list
		List<Product> Products = theQuery.getResultList();
		
		// return the results		
		return Products;
	}


	@Override
	public Product findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the Product
		Product theProduct =
				currentSession.get(Product.class, theId);
		
		// return the Product
		return theProduct;
	}


	@Override
	public void save(Product theProduct) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save Product
		currentSession.saveOrUpdate(theProduct);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Product where product_id=:productId");
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();
	}
}