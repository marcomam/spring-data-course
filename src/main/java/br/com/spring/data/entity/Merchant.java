package br.com.spring.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MERCHANTS")
public class Merchant implements Serializable{
	
	private static final long serialVersionUID = -3659180701329905165L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "MERCHANT_NAME")
	private String merchantName;
	
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	public Merchant() {
		
	}
	
	public Merchant(Integer id, String merchantName, LocalDateTime createdAt) {
		this.id = id;
		this.merchantName = merchantName;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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
		Merchant other = (Merchant) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", merchantName=" + merchantName + ", createdAt=" + createdAt + "]";
	}
}
