package br.com.spring.data.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.spring.data.dao.CustomerDAO;
import br.com.spring.data.entity.Customer;
import br.com.spring.data.repository.CustomerRepository;
import br.com.spring.data.service.CustomerService;
import br.com.spring.data.service.utils.EntityUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer create(Customer obj) {
		obj.setCreatedAt(LocalDateTime.now());
		return customerRepository.save(obj);
	}

	@Override
	public Customer update(Customer obj) {
		if(obj.getId() != null) {
			Customer customerToUpdate = findById(obj.getId());
			EntityUtils.prepareEntityForUpdate(customerToUpdate, obj);
			return customerRepository.save(customerToUpdate);
		}
		throw new ResourceNotFoundException("Customer");
	}

	@Override
	public Customer findById(Integer id) {
		Optional<Customer> customerOpt = customerRepository.findById(id);
		
		if(!customerOpt.isPresent()) {
			throw new ResourceNotFoundException("Customer");
		}
				
		return customerOpt.get();
	}
	
	@Override
	public List<Customer> findAll() {
//		return customerRepository.findAll();
		return customerDAO.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		customerRepository.deleteById(id);
	}
}
