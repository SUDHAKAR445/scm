package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.CertificateAgency;


@Repository
public interface CertificateAgencyRepository extends MongoRepository<CertificateAgency, String>{
	CertificateAgency findByAgencyid(String agencyid);
}
