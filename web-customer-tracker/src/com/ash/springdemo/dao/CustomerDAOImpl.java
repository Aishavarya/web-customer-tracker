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
		
		
		session.saveOrUpdate(theCustomer);
		
		
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Customer theCustomer=session.get(Customer.class, id);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		
		Query theQuery=session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
		//Another way of deleting the customer
		
		//Customer theCustomer=session.get(Customer.class, id);
		
		//session.delete(theCustomer);
		
	}

}
