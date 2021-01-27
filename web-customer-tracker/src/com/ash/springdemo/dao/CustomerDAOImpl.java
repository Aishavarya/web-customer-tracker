package com.ash.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ash.springdemo.entity.Customer;

@Repository //always applied to DAO Impl
public class CustomerDAOImpl implements CustomerDAO {
	
	//Injecting the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create query
		
		Query<Customer> theQuery=session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		
		List<Customer> customers=theQuery.getResultList();
		
		//return result
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		
		Session session=sessionFactory.getCurrentSession();
		session.save(theCustomer);
	}

}
