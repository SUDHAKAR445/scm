package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.CertificateDetails;


@Repository
public interface CertificateDetailsRepository extends MongoRepository<CertificateDetails,String>{
    CertificateDetails findByCertificateID(String certificateID);
}
