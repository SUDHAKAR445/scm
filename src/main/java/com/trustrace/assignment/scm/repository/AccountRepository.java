package com.trustrace.assignment.scm.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.Account;


@Repository
public interface AccountRepository extends MongoRepository<Account, String>{
	Account findByBrandid(String brandid);
}
