package com.trustrace.assignment.scm.service;

import java.util.List;
import java.util.Optional;


import com.trustrace.assignment.scm.model.CertificateAgency;

public interface CertificateAgencyService 
{
	
	List<CertificateAgency> getAllAgency();
	
	Optional<CertificateAgency> getById(String _id);
	
	CertificateAgency saveAgency(CertificateAgency a );
	
	CertificateAgency updateAgency(CertificateAgency a);
	
	void deleteAgency(String _id);
	
}
