package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.model.CertificateDetails;
import com.trustrace.assignment.scm.repository.CertificateDetailsRepository;
import com.trustrace.assignment.scm.service.CertificateDetailsService;

@Service
public class CertificateDetailsServiceImp implements CertificateDetailsService{
	
	@Autowired
	CertificateDetailsRepository certificateDetailsRepo;
	
	
	public List<CertificateDetails> getAllCertificate(){
		return certificateDetailsRepo.findAll();
	}
	
	public CertificateDetails getById(String id){
		CertificateDetails _id = certificateDetailsRepo.findByCertificateID(id);
		return certificateDetailsRepo.findById(_id.get_id()).get();
	}
	
	public String saveCertificate(CertificateDetails a) {
		CertificateDetails id = certificateDetailsRepo.findByCertificateID(a.getCertificateID());
		if(id==null)
		{
			// String _i = a.getAgencyID().getAgencyid();
			// String o_i = certificateDetailsRepo.findByAgencyid(o_id)
			certificateDetailsRepo.save(a);
			return "Certificate details saved successfully : ";
	    }
		else
		{
			return "Certificate details already exists";
		}
	}
	
	public String updateCertificate(CertificateDetails a) {
		CertificateDetails id = certificateDetailsRepo.findByCertificateID(a.getCertificateID());
		if(id!=null)
		{
			certificateDetailsRepo.save(a);
			return "Certificate details updated successfully : "+id.get_id();
	    }
		else
		{
			return "Certififcate Details doesn't exists";
		}
	}
	
	public String deleteCertificate(String id) {
		CertificateDetails _id = certificateDetailsRepo.findByCertificateID(id);
		if(id!=null)
		{
			certificateDetailsRepo.deleteById(_id.get_id());
			return "CertificSate details deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "Certififcate Details doesn't exists";
		}
	}

	
}
