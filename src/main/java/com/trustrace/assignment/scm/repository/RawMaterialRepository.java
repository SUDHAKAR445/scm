package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trustrace.assignment.scm.model.RawMaterial;


public interface RawMaterialRepository extends MongoRepository<RawMaterial,String> {
    RawMaterial findByRawMaterialID(String rawmaterialID);
}
