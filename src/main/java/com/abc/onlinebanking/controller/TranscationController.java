package com.abc.onlinebanking.controller;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.abc.onlinebanking.domain.CustomerDetails;
import com.abc.onlinebanking.domain.TranscationDetails;
import com.abc.onlinebanking.service.CustomerService;
import com.abc.onlinebanking.service.TranscationService;  

//creating RestController  
@RestController 

public class TranscationController {
	//auto wired the StudentService class  
	
	@Autowired  
	TranscationService transcationService;  
	
	//creating a get mapping that retrieves all the students detail from the database   
	@GetMapping("/TranscationDetails")  
	private List<TranscationDetails> getAllTranscation()   
	{  
		return transcationService.getAllTranscations();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/TranscationDetails/{id}")  
	private TranscationDetails getCTranscation(@PathVariable("id") int id)   
	{  
		return transcationService.getTranscationById(id);  
	}  
	
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/TranscationDetails/{id}")  
	private void deleteTranscation(@PathVariable("id") int id)   
	{  
		transcationService.delete(id);  
	}  
	
	//creating post mapping that post the student detail in the database  
	@PostMapping("/TranscationDetails")  
	private String saveTranscation(@RequestBody TranscationDetails transcation)   
	{  
		transcationService.saveOrUpdate(transcation); 
		return "value saved";
		//return CustomerService.getCustomerId();  
	}
}