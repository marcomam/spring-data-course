package br.com.spring.data.dao;

import org.springframework.stereotype.Repository;

import br.com.spring.data.entity.Customer;

@Repository
public class CustomerDAO extends AbstractHibernateDAO<Customer>{

	public CustomerDAO() {
		setClazz(Customer.class);
	}
}
