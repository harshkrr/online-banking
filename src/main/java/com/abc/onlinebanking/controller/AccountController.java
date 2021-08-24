package com.abc.onlinebanking.controller;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;

import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.domain.CustomerDetails;
import com.abc.onlinebanking.service.AccountService;
import com.abc.onlinebanking.service.CustomerService;  

//creating RestController  
@RestController 

public class AccountController {
	//auto wired the StudentService class  
	
	@Autowired  
	AccountService accountService;  
	
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/AccountDetails")  
	private List<AccountDetails> getAllAccount()   
	{  
		return accountService.getAllAccount();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/AccountDetails/{id}")  
	private AccountDetails getAccount(@PathVariable("id") int id)   
	{  
		return accountService.getAccountById(id);  
	}  
	
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/AccountDetails/{id}")  
	private void deleteAccount(@PathVariable("id") int id)   
	{  
		accountService.delete(id);  
	}  
	
	//creating post mapping that post the student detail in the database  
	@PostMapping("/AccountDetails")  
	private String saveAccount(@RequestBody AccountDetails account)   
	{  
		accountService.saveOrUpdate(account); 
		return "value saved";
		//return CustomerService.getCustomerId();  
	}
}

