package com.abc.onlinebanking.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service; 
import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.repository.*;

@Service  
public class AccountService {
	@Autowired  
	AccountRepository accountRepository;  
	
	//getting all student records  
	public List<AccountDetails> getAllAccount()   
	{  
		List<AccountDetails> accounts = new ArrayList<AccountDetails>();  
		accountRepository.findAll().forEach(account -> accounts.add(account));  
		return accounts;  
	}  
	
	//getting a specific record  
	public AccountDetails getAccountById(int id)   
	{  
		return accountRepository.findById(id).get();  
	}  
	public void saveOrUpdate(AccountDetails account)   
	{  
		accountRepository.save(account);  
	}  
	//deleting a specific record  
	public void delete(int id)   
	{  
		accountRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(AccountDetails account, String accountid)   
	{  
		accountRepository.save(account);  
	}  
}
