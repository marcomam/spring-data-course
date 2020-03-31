package br.com.spring.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 7528637051140821429L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "MERCHANT_ID", referencedColumnName = "ID")
	private Merchant merchant;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	public Product() {
		
	}
	
	public Product(Integer id, String name, Merchant merchant, Double price, String status, LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.merchant = merchant;
		this.price = price;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", merchant=" + merchant.getId() + ", price=" + price + ", status="
				+ status + ", createdAt=" + createdAt + "]";
	}
	
	
}
