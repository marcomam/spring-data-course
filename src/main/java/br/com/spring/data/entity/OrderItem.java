package br.com.spring.data.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEMS") //É opcional, pois por padrão 'OrderItems' é mapeado para 'ORDER_ITEMS'
public class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 4574624202831982118L;

	@EmbeddedId
	private OrderItemKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private Product product;
	
	@Column(name = "QUANTITY") //É opcional
	private Integer quantity;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Order order, Product product, Integer quantity) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.id = new OrderItemKey(order.getId(), product.getId());
	}

	public OrderItemKey getId() {
		return id;
	}

	public void setId(OrderItemKey id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		if(id == null) {
			id = new OrderItemKey();
		}
		id.setOrderId(order.getId());
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		if(id == null) {
			id = new OrderItemKey();
		}
		id.setProductId(product.getId());
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", quantity=" + quantity + "]";
	}
}
