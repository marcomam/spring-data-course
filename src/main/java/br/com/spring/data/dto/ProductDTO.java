package br.com.spring.data.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ProductDTO {
	
	private Integer id;
	private String name;
	private MerchantDTO merchant;
	private Double price;
	private String status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Integer id, String name, MerchantDTO merchant, Double price, String status, LocalDateTime createdAt) {
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

	public MerchantDTO getMerchant() {
		return merchant;
	}

	public void setMerchant(MerchantDTO merchant) {
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
}
