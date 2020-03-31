package br.com.spring.data.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemKey implements Serializable {
	
	private static final long serialVersionUID = -5391473740043082387L;

	@Column(name = "ORDER_ID")
	private Integer orderId;
	
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	public OrderItemKey() {
		
	}

	public OrderItemKey(Integer orderId, Integer productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemKey other = (OrderItemKey) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
	}

	@Override
	public String toString() {
		return "OrderItemsKey [orderId=" + orderId + ", productId=" + productId + "]";
	}
}
