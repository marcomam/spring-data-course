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

import br.com.spring.data.dto.OrderDTO;
import br.com.spring.data.dto.OrderItemDTO;
import br.com.spring.data.entity.Order;
import br.com.spring.data.entity.OrderItem;
import br.com.spring.data.service.OrderService;
import br.com.spring.data.service.utils.EntityUtils;

@RestController
@RequestMapping("${order.servlet.path}")
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<Order> orders = orderService.findAll();

		List<OrderDTO> dtos = EntityUtils.mapAll(orders, OrderDTO.class);

		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Integer id) {
		Order order = orderService.findById(id);

		return ResponseEntity.ok().body(EntityUtils.map(OrderDTO.class, order));
	}

	@PostMapping
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
		Order order = EntityUtils.map(Order.class, orderDto);

		Order createdOrder = orderService.create(order);

		return ResponseEntity.status(HttpStatus.CREATED).body(EntityUtils.map(OrderDTO.class, createdOrder));
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDto, @PathVariable("id") Integer id) {
		Order order = EntityUtils.map(Order.class, orderDto);

		order.setId(id);

		order = orderService.update(order);

		return ResponseEntity.ok().body(EntityUtils.map(OrderDTO.class, order));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("id") Integer id) {
		Order order = orderService.findById(id);

		orderService.deleteById(id);

		return ResponseEntity.ok().body(EntityUtils.map(OrderDTO.class, order));
	}
	
	@PostMapping("/{id}/close")
	public ResponseEntity<OrderDTO> closeOrder(@PathVariable("id") Integer id) {
		Order order = orderService.closeOrder(id);

		return ResponseEntity.ok().body(EntityUtils.map(OrderDTO.class, order));
	}

	// Order Items

	@PostMapping("/{orderId}/item")
	public ResponseEntity<OrderDTO> createOrderItem(@PathVariable("orderId") Integer orderId,
			@RequestBody OrderItemDTO orderItemDto) {
		OrderItem orderItem = EntityUtils.map(OrderItem.class, orderItemDto);
		
		Order orderWithItem = orderService.addOrderItem(orderId, orderItem);

		return ResponseEntity.status(HttpStatus.CREATED).body(EntityUtils.map(OrderDTO.class, orderWithItem));
	}

	@DeleteMapping("/{orderId}/item/{itemProductId}")
	public ResponseEntity<OrderDTO> deleteOrderItem(@PathVariable("orderId") Integer orderId,
			@PathVariable("itemProductId") Integer itemId) {
		Order order = orderService.removeOrderItem(orderId, itemId);

		return ResponseEntity.ok().body(EntityUtils.map(OrderDTO.class, order));
	}
}
