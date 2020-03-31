package br.com.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.data.dto.CustomerDTO;
import br.com.spring.data.entity.Customer;
import br.com.spring.data.service.CustomerService;
import br.com.spring.data.service.utils.EntityUtils;

@RestController
@RequestMapping("${customer.servlet.path}")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		List<Customer> customers = customerService.findAll();

		List<CustomerDTO> dtos = EntityUtils.mapAll(customers, CustomerDTO.class);

		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") Integer id) {
		Customer customer = customerService.findById(id);

		return ResponseEntity.ok().body(EntityUtils.map(CustomerDTO.class, customer));
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDto) {
		Customer customer = EntityUtils.map(Customer.class, customerDto);

		Customer createdCustomer = customerService.create(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body(EntityUtils.map(CustomerDTO.class, createdCustomer));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDto,
			@PathVariable("id") Integer id) {
		Customer customer = EntityUtils.map(Customer.class, customerDto);

		customer.setId(id);

		customer = customerService.update(customer);

		return ResponseEntity.ok().body(EntityUtils.map(CustomerDTO.class, customer));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") Integer id) {
		Customer customer = customerService.findById(id);

		customerService.deleteById(id);

		return ResponseEntity.ok().body(EntityUtils.map(CustomerDTO.class, customer));
	}
}
