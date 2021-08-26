package com.abc.onlinebanking.service;
import java.util.ArrayList;  
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.dto.CustomerDTO;
import com.abc.onlinebanking.repository.*;

@Service  
public class CustomerService {
	 
	private final CustomerRepository customerRepository;  
	private final AccountService accountService;
	
	@Autowired 
	public CustomerService(CustomerRepository customerRepository, AccountService accountService) {
		super();
		this.customerRepository = customerRepository;
		this.accountService = accountService;
	}

	//getting all student records  
	public List<CustomerDetails> getAllCustomers()   
	{  
		List<CustomerDetails> customers = new ArrayList<CustomerDetails>();  
		customerRepository.findAll().forEach(customer -> customers.add(customer));  
		return customers;  
	}  
	
	//getting a specific record  
	public CustomerDetails getCustomerById(String id)   
	{  
		return customerRepository.findById(id).get();  
	}  
	public CustomerDetails saveOrUpdate(CustomerDetails customer)   
	{  
		return customerRepository.save(customer);  
	}  
	//deleting a specific record  
	public CustomerDetails delete(String id)   
	{  
		CustomerDetails customer = getCustomerById(id);
		customerRepository.deleteById(id);  
		return customer;
	}  
	//updating a record  
	public CustomerDetails update(CustomerDetails customer, String customerid)   
	{  
		return customerRepository.save(customer);  
	}  
//	@Transactional
//    public CustomerDetails editCustomerDetails(String id, CustomerDetails customerDetails){
//		CustomerDetails cartToEdit = getCustomerById(id);
//        cartToEdit.setName(cart.getName());
//        return cartToEdit;
//    }
	@Transactional
	public CustomerDetails addAccountDetailsToCustomerDetails(String customerId, String accountId) {
		CustomerDetails customer = getCustomerById(customerId);
		AccountDetails account = accountService.getAccountById(accountId);
		account.setCustomerDetails(customer);
		customer.addAccountDetails(account);
		return customer;
	}
	@Transactional
	public CustomerDetails removeAccountDetailsFromCustomerDetails(String customerId, String accountId) {
		CustomerDetails customer = getCustomerById(customerId);
		AccountDetails account = accountService.getAccountById(accountId);
		customer.removeAccountDetails(account);
		return customer;
	}
	
}
