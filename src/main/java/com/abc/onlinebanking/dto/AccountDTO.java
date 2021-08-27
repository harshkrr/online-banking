package com.abc.onlinebanking.dto;

import java.time.LocalDate;

import com.abc.onlinebanking.domain.AccountDetails;

public class AccountDTO {
	String accountNumber;
	Float accountBalance;
	LocalDate dateCreated;
	static PlainCustomerDTO plainCustomerDTO;
	
	public AccountDTO() {
		super();
	}
	
	public AccountDTO(String accountNumber, float accountBalance, LocalDate dateCreated) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.dateCreated = dateCreated;
	}
	
	public static AccountDTO from(AccountDetails accountDetails) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(accountDetails.getAccountNumber());
		accountDTO.setAccountBalance(accountDetails.getAccountBalance());
		accountDTO.setDateCreated(accountDetails.getDateCreated());
		accountDTO.setPlainCustomerDTO(plainCustomerDTO.from(accountDetails.getCustomerDetails()));
		return accountDTO;
	}

	public PlainCustomerDTO getPlainCustomerDTO() {
		return plainCustomerDTO;
	}

	public void setPlainCustomerDTO(PlainCustomerDTO plainCustomerDTO) {
		this.plainCustomerDTO = plainCustomerDTO;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float f) {
		this.accountBalance = f;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
