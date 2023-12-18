package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.CertificateDetails;

public interface CertificateDetailsService {
	
	List<CertificateDetails> getAllCertificate();
	
	CertificateDetails getById(String _id);
	
	String saveCertificate(CertificateDetails a);
	
	String updateCertificate(CertificateDetails a);
	
	String deleteCertificate(String _id);
}
