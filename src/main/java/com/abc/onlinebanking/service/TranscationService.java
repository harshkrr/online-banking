package com.abc.onlinebanking.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service; 
import com.abc.onlinebanking.domain.*;
import com.abc.onlinebanking.repository.*;

@Service  
public class TranscationService {
	@Autowired  
	TranscationRepository transcationRepository;  
	
	//getting all student records  
	public List<TranscationDetails> getAllTranscations()   
	{  
		List<TranscationDetails> transcations = new ArrayList<TranscationDetails>();  
		transcationRepository.findAll().forEach(transcation -> transcations.add(transcation));  
		return transcations;  
	}  
	
	//getting a specific record  
	public TranscationDetails getTranscationById(long id)   
	{  
		return transcationRepository.findById(id).get();  
	}  
	public void saveOrUpdate(TranscationDetails transcation)   
	{  
		transcationRepository.save(transcation);  
	}  
	//deleting a specific record  
	public void delete(long id)   
	{  
		transcationRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(TranscationDetails transcation, String transcationid)   
	{  
		transcationRepository.save(transcation);  
	}  
}
