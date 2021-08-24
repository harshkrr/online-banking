package com.abc.onlinebanking.domain;
import java.time.*;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.Table;
	
@Entity
@Table(name = "ACCOUNT")

public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String accountNumber;
	
	@OneToMany(targetEntity = TranscationDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name="transcation_fk", referencedColumnName = "accountNumber")
	private List<TranscationDetails> transcationDetails;
		
	@Column(name = "ACC_BALANCE")
	private float accountBalance;
	
	@Column(name = "DATE_CREATED")
	private LocalDate dateCreated;
	
	
	public AccountDetails(String accountNumber, float accountBalance, LocalDate dateCreated) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.dateCreated = dateCreated;
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
	
	
}
