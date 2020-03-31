package br.com.spring.data.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class MerchantDTO {
	
	private Integer id;
	private String merchantName;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;
	
	public MerchantDTO() {
		
	}
	
	public MerchantDTO(Integer id, String merchantName, LocalDateTime createdAt) {
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
}
