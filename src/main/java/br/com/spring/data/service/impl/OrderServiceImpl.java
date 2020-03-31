package br.com.spring.data.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import br.com.spring.data.entity.Order;
import br.com.spring.data.entity.OrderItem;
import br.com.spring.data.repository.OrderRepository;
import br.com.spring.data.service.OrderService;
import br.com.spring.data.service.utils.EntityUtils;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	private static final String NEW_STATUS = "NEW";
	private static final String CURRENT_STATUS = "CURRENT";
	private static final String CLOSED_STATUS = "CLOSED";

	@Override
	public Order create(Order obj) {
		obj.setCreatedAt(LocalDateTime.now());
		obj.setStatus(NEW_STATUS);
		return orderRepository.save(obj);
	}

	@Override
	public Order update(Order obj) {
		if(obj.getId() != null) {
			Order orderToUpdate = findById(obj.getId());
			EntityUtils.prepareEntityForUpdate(orderToUpdate, obj);
			return orderRepository.save(orderToUpdate);
		}
		throw new ResourceNotFoundException("Order");
	}

	@Override
	public Order findById(Integer id) {
		Optional<Order> orderOpt = orderRepository.findById(id);
		
		if(!orderOpt.isPresent()) {
			throw new ResourceNotFoundException("Order");
		}
		
		return orderOpt.get();
	}
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}
	
	public Order addOrderItem(Integer orderId, OrderItem orderItem) {
		Order order = findById(orderId);
		updateOpenOrder(order);
		
		order.addOrderItem(orderItem);
		
		try {
			order = orderRepository.save(order);
		}
		catch(JpaObjectRetrievalFailureException e) {
			throw new ResourceNotFoundException("Product");
		}
		
		return order;
				
	}
	
	public Order removeOrderItem(Integer orderId, Integer itemProductId) {
		Order order = findById(orderId);
		updateOpenOrder(order);
		
		order.removeOrderItem(itemProductId);
		
		return orderRepository.save(order);
	}
	
	@Override
	public Order closeOrder(Integer id) {
		Order order = findById(id);
		order.setStatus(CLOSED_STATUS);
		return orderRepository.save(order);
	}
	
	protected void updateOpenOrder(Order order) {
		if(order.getStatus().equals(NEW_STATUS)) {
			order.setStatus(CURRENT_STATUS);
		}
		else if(order.getStatus().equals(CLOSED_STATUS)) {
			throw new IllegalArgumentException("A ordem n\u00E3o pode estar fechada");
		}
	}
}
