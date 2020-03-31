package br.com.spring.data.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class CustomerDTO {
	
	private Integer id;
	private String fullName;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;
	
	private String cpf;
	private AddressDTO address;
	
	public CustomerDTO() {
		
	}
	
	public CustomerDTO(Integer id, String fullName, LocalDateTime createdAt, String cpf, AddressDTO address) {
		this.id = id;
		this.fullName = fullName;
		this.createdAt = createdAt;
		this.cpf = cpf;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}
