package com.abc.onlinebanking.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.domain.CustomerDetails;

public class CustomerDTO {

	String customerId;
	String name;
	LocalDate dateOfBirth;
	String address;
	String city;
	Long phone;
	List<AccountDTO> accountDTO = new ArrayList<>();
	
	public CustomerDTO(String customerId, String name, LocalDate dateOfBirth, String address, String city, Long phone,
			List<AccountDTO> accountDTO) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.accountDTO = accountDTO;
	}
	
	public CustomerDTO() {
		super();
	}

	public static CustomerDTO from(CustomerDetails customerDetails) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress(customerDetails.getAddress());
		customerDTO.setCity(customerDetails.getCity());
		customerDTO.setCustomerId(customerDetails.getCustomerId());
		customerDTO.setDateOfBirth(customerDetails.getDateOfBirth());
		customerDTO.setName(customerDetails.getName());
		customerDTO.setPhone(customerDetails.getPhone());
		customerDTO.setAccountDTO(customerDetails.getAccountDetails().stream().map(AccountDTO::from).collect(Collectors.toList()));
		return customerDTO;
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
	
	public void setAccountDTO(List<AccountDTO> accountDTO) {
		this.accountDTO = accountDTO;
	}

//	public List<AccountDetails> getAccountDetails() {
//		return getAccountDetails();
//	}
//
//	public void setAccountDetails(List<AccountDetails> accountDetails) {
//		this.accountDetails = accountDetails;
//	}
	
	
		
}
