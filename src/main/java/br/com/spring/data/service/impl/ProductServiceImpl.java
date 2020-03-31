package br.com.spring.data.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.spring.data.entity.Product;
import br.com.spring.data.repository.ProductRepository;
import br.com.spring.data.service.ProductService;
import br.com.spring.data.service.utils.EntityUtils;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product create(Product obj) {
		obj.setCreatedAt(LocalDateTime.now());
		return productRepository.save(obj);
	}

	@Override
	public Product update(Product obj) {
		if(obj.getId() != null) {
			Product productToUpdate = findById(obj.getId());
			EntityUtils.prepareEntityForUpdate(productToUpdate, obj);
			return productRepository.save(productToUpdate);
		}
		throw new ResourceNotFoundException("Product");
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> productOpt = productRepository.findById(id);
		
		if(!productOpt.isPresent()) {
			throw new ResourceNotFoundException("Product");
		}
		
		return productOpt.get();
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}
}
