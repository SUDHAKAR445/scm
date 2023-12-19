package com.trustrace.assignment.scm.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trustrace.assignment.scm.model.Production;
import java.util.List;



public interface ProductionRepository extends MongoRepository<Production,String>{
    Production findByProductionID(String productionID);
}
