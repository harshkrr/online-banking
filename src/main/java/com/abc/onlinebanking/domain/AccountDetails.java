package com.abc.onlinebanking.domain;
import java.time.*;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.abc.onlinebanking.dto.AccountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
	
@Entity
@Table(name = "ACCOUNT")

public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountNumber;
	
//	@ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "customer_id", nullable = false)
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private CustomerDetails customerDetails;
	@ManyToOne
	private CustomerDetails customerDetails;
	
	@Column(name = "ACC_BALANCE")
	private float accountBalance;
	
	@Column(name = "DATE_CREATED")
	private LocalDate dateCreated;
	
	
	public AccountDetails() {
	}
	
	public AccountDetails(String accountNumber, float accountBalance, LocalDate dateCreated) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.dateCreated = dateCreated;
	}
	
	public static AccountDetails from(AccountDTO accountDTO) {
		AccountDetails account = new AccountDetails();
	    account.setAccountBalance(accountDTO.getAccountBalance());
	    account.setAccountNumber(accountDTO.getAccountNumber());
	    account.setDateCreated(accountDTO.getDateCreated());
	    return account;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}


	
	
	
}
