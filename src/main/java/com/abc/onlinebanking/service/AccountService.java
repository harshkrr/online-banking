package com.abc.onlinebanking.service;
import java.util.ArrayList;  
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service; 
import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.repository.*;

@Service  
public class AccountService {
	  
	AccountRepository accountRepository;  
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	
	//getting all student records  
	public List<AccountDetails> getAllAccounts()   
	{  
		List<AccountDetails> accounts = new ArrayList<AccountDetails>();  
		accountRepository.findAll().forEach(account -> accounts.add(account));  
		return accounts;  
	}  
	
	//getting a specific record  
	public AccountDetails getAccountById(String id)   
	{  
		return accountRepository.findById(id).get();  
	}  
	
	public AccountDetails saveOrUpdate(AccountDetails account)   
	{  
		return accountRepository.save(account);  
	}  
	//deleting a specific record  
	public AccountDetails delete(String id)   
	{  
		AccountDetails ad = getAccountById(id);
		accountRepository.deleteById(id);  
		return ad;
	}  
	//updating a record  
	@Transactional
    public AccountDetails editItem(String id, AccountDetails item){
		AccountDetails itemToEdit = getAccountById(id);
        itemToEdit.setAccountBalance(item.getAccountBalance());
        itemToEdit.setAccountNumber(item.getAccountNumber());
        itemToEdit.setDateCreated(item.getDateCreated());
        return itemToEdit;
    }
	
	public AccountDetails update(AccountDetails account, String accountid)   
	{  
		return accountRepository.save(account);  
	}  
}
