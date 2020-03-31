package br.com.spring.data.dto;

public class AddressDTO {
	
	private Integer id;
	private String street;
	private Integer number;
	private String city;
	private String state;
	
	public AddressDTO() {
		
	}

	public AddressDTO(Integer id, String street, Integer number, String city, String state) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
