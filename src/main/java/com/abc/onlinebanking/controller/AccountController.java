package com.abc.onlinebanking.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.abc.onlinebanking.domain.AccountDetails;
import com.abc.onlinebanking.dto.AccountDTO;
import com.abc.onlinebanking.service.AccountService;
import com.abc.onlinebanking.service.CustomerService;

//creating RestController
@RestController
public class AccountController
{
    //auto wired the AccountService class
    AccountService accountService;
    
    @Autowired
    public AccountController(AccountService accountServive) {
		this.accountService = accountServive;
    }

    //creating a get mapping that retrieves all the account details from the database
    @GetMapping("/account")
    private ResponseEntity<List<AccountDTO>> getAllAccounts()
    {
        List<AccountDetails> accounts =  accountService.getAllAccounts();
        List<AccountDTO> accountsDTO = accounts.stream().map(AccountDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(accountsDTO, HttpStatus.OK);
    }

    //creating a get mapping that retrieves the detail of a specific acc
    @GetMapping("/account/{id}")
    private ResponseEntity<AccountDTO>  getAccount(@PathVariable("id") String id)
    {
        AccountDetails accountDetails =  accountService.getAccountById(id);
        return new ResponseEntity<>(AccountDTO.from(accountDetails), HttpStatus.OK);
    }

    //creating a delete mapping that deletes a specific account
    @DeleteMapping("/account/{id}")
    private ResponseEntity<AccountDTO> deleteAccount(@PathVariable("id") String id)
    {
    	AccountDetails accountDetails = accountService.delete(id);
    	 return new ResponseEntity<>(AccountDTO.from(accountDetails), HttpStatus.OK);
    }

    //creating post mapping that post the account detail in the database
    @PostMapping("/account")
    private ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO)
    {
        AccountDetails account = accountService.saveOrUpdate(AccountDetails.from(accountDTO));
        return new ResponseEntity<>(AccountDTO.from(account), HttpStatus.OK);
    }
    
    @PutMapping(value = "/account/{id}")
    public ResponseEntity<AccountDTO> editItem(@PathVariable String id,
                                            @RequestBody final AccountDTO accountDTO){
    	AccountDetails editedItem = accountService.update(AccountDetails.from(accountDTO), id);
        return new ResponseEntity<>(AccountDTO.from(editedItem), HttpStatus.OK);
    }
}