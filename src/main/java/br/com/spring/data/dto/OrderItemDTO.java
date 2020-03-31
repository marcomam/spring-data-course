package br.com.spring.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderItemDTO {
	
	@JsonIgnore
	private OrderDTO order;
	private ProductDTO product;
	private Integer quantity;
	
	public OrderItemDTO() {
		
	}
	
	public OrderItemDTO(OrderDTO order, ProductDTO product, Integer quantity) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
