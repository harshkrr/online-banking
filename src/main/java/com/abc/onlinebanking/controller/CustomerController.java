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
import com.abc.onlinebanking.domain.CustomerDetails;
import com.abc.onlinebanking.dto.AccountDTO;
import com.abc.onlinebanking.dto.CustomerDTO;
import com.abc.onlinebanking.service.AccountService;
import com.abc.onlinebanking.service.CustomerService;

//creating RestController

@RestController
public class CustomerController
{
    //auto wired the CustomerService class
    CustomerService customerService;
    
    @Autowired
    public CustomerController(CustomerService customerService) {
    	this.customerService = customerService;
    }
    

    //creating a get mapping that retrieves all the customers detail from the database
    @GetMapping("/customer")
    private ResponseEntity<List<CustomerDTO>> getAllCustomers()
    {
        List<CustomerDetails> customers = customerService.getAllCustomers();
        List<CustomerDTO> cartsDto = customers.stream().map(CustomerDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartsDto, HttpStatus.OK);
    }

    //creating a get mapping that retrieves the detail of a specific customer
    @GetMapping("/customer/{id}")
    private ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") String id)
    {
        CustomerDetails customer =  customerService.getCustomerById(id);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

    //creating a delete mapping that deletes a specific customer
    @DeleteMapping("/customer/{id}")
    private ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") String id)
    {
    	CustomerDetails customer = customerService.delete(id);
    	return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

    //creating post mapping that post the customer detail in the database
    @PostMapping("/customer")
    private ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDetails customer = customerService.saveOrUpdate(CustomerDetails.from(customerDTO));
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }
    
    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerDTO> editItem(@PathVariable String id,
                                            @RequestBody final CustomerDTO customerDTO){
    	CustomerDetails editedItem = customerService.update(CustomerDetails.from(customerDTO), id);
        return new ResponseEntity<>(CustomerDTO.from(editedItem), HttpStatus.OK);
    }
    
    @PostMapping(value = "{customerId}/accounts/{accountId}/add")
    public ResponseEntity<CustomerDTO> addAccountDetailsToCustomerDetails(@PathVariable final String customerId,
                                                 @PathVariable final String accountId){
		CustomerDetails customer = customerService.addAccountDetailsToCustomerDetails(customerId, accountId);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{customerId}/accounts/{accountId}/remove")
    public ResponseEntity<CustomerDTO> removeAccountDetailsFromCustomerDetails(@PathVariable final String customerId,
                                                 @PathVariable final String accountId){
    	CustomerDetails customer = customerService.removeAccountDetailsFromCustomerDetails(customerId, accountId);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }
}