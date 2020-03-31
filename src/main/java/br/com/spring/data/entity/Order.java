package br.com.spring.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{
	
	private static final long serialVersionUID = -6550803003070959399L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	private Customer customer;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItem> orderItems = new HashSet<>();
	
	public Order() {
		
	}

	public Order(Integer id, Customer customer, String status, Set<OrderItem> orderItems, LocalDateTime createdAt) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
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

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		orderItems.add(orderItem);
    }
	
	public void removeOrderItem(Integer itemProductId) {
		orderItems.removeIf(i -> i.getProduct().getId().equals(itemProductId));
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer.getId() + ", status=" + status + ", createdAt=" + createdAt
				+ "]";
	}
}
