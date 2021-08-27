package com.abc.onlinebanking.dto;

import java.time.LocalDate;
import java.util.stream.Collectors;

import com.abc.onlinebanking.domain.CustomerDetails;

public class PlainCustomerDTO {
	String customerId;
	String name;
	LocalDate dateOfBirth;
	String address;
	String city;
	Long phone;

    public static PlainCustomerDTO from(CustomerDetails customerDetails){
    	PlainCustomerDTO plainCustomerDto = new PlainCustomerDTO();
    	plainCustomerDto.setAddress(customerDetails.getAddress());
    	plainCustomerDto.setCity(customerDetails.getCity());
    	plainCustomerDto.setCustomerId(customerDetails.getCustomerId());
    	plainCustomerDto.setDateOfBirth(customerDetails.getDateOfBirth());
    	plainCustomerDto.setName(customerDetails.getName());
    	plainCustomerDto.setPhone(customerDetails.getPhone());
    	return plainCustomerDto;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
