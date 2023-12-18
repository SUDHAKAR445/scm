package com.trustrace.assignment.scm.dao.implementation;



import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.dao.DaoService;
import com.trustrace.assignment.scm.model.Account;

@Repository
public class DaoServiceImp implements DaoService{

    MongoTemplate template;

	public DaoServiceImp(MongoTemplate template) {
		this.template = template;
	}

    public String updateAccountName(String id, String newName) {

        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);

        Update update = new Update().set("name", newName);
        template.updateFirst(query, update, Account.class);

        return "Name updated Successfully by id";
    }
    
}
