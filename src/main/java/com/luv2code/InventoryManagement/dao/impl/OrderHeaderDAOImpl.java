package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.InventoryManagement.dao.OrderHeaderDAO;
import com.luv2code.InventoryManagement.entity.Customer;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderLine;

@Repository
@Transactional
public class OrderHeaderDAOImpl implements OrderHeaderDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<OrderHeader> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<OrderHeader> theQuery =
				currentSession.createQuery("from OrderHeader", OrderHeader.class);
		
		// execute query and get result list
		List<OrderHeader> OrderHeaders = theQuery.getResultList();
		
		// return the results		
		return OrderHeaders;
	}


	@Override
	public OrderHeader findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the OrderHeader
		OrderHeader theOrderHeader =
				currentSession.get(OrderHeader.class, theId);
		
		// return the OrderHeader
		return theOrderHeader;
	}


	@Override
	public void save(OrderHeader theOrderHeader) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save OrderHeader
		currentSession.saveOrUpdate(theOrderHeader);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from OrderHeader where order_header_id=:orderHeaderId");
		theQuery.setParameter("orderHeaderId", theId);
		
		theQuery.executeUpdate();
	}

}
