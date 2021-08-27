package com.abc.onlinebanking.repository;
import org.springframework.data.repository.CrudRepository;  
import com.abc.onlinebanking.domain.*;

public interface TranscationRepository extends CrudRepository<TranscationDetails, Long>  {

}
