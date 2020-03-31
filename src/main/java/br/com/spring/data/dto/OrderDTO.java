package br.com.spring.data.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class OrderDTO {
	
	private Integer id;
	private CustomerDTO customer;
	private String status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;
	
	private Set<OrderItemDTO> orderItems;
	
	public OrderDTO() {
		
	}

	public OrderDTO(Integer id, CustomerDTO customer, String status, Set<OrderItemDTO> orderItems, LocalDateTime createdAt) {
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.orderItems = orderItems;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
}
