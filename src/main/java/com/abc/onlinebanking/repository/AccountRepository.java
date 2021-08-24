package com.abc.onlinebanking.repository;
import org.springframework.data.repository.CrudRepository;  
import com.abc.onlinebanking.domain.*;

public interface AccountRepository extends CrudRepository<AccountDetails, Integer>  {

}
