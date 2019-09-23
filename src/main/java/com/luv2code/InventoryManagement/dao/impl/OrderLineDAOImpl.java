package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.InventoryManagement.dao.OrderLineDAO;
import com.luv2code.InventoryManagement.entity.OrderLine;
@Repository
public class OrderLineDAOImpl implements OrderLineDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<OrderLine> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<OrderLine> theQuery =
				currentSession.createQuery("from OrderLine", OrderLine.class);
		
		// execute query and get result list
		List<OrderLine> OrderLines = theQuery.getResultList();
		
		// return the results		
		return OrderLines;
	}


	@Override
	public OrderLine findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the OrderLine
		OrderLine theOrderLine =
				currentSession.get(OrderLine.class, theId);
		
		// return the OrderLine
		return theOrderLine;
	}


	@Override
	public void save(OrderLine theOrderLine) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save OrderLine
		currentSession.saveOrUpdate(theOrderLine);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from OrderLine where order_line_id=:orderLineId");
		theQuery.setParameter("orderLineId", theId);
		
		theQuery.executeUpdate();
	}


}
