package com.trustrace.assignment.scm.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.repository.CertificateAgencyRepository;
import com.trustrace.assignment.scm.service.CertificateAgencyService;
import com.trustrace.assignment.scm.exception.MyNotFoundException;

@Service
public class CertificateAgencyServiceImp implements CertificateAgencyService {
	
	@Autowired
	CertificateAgencyRepository certificateAgencyRepo;

	@Override
	public List<CertificateAgency> getAllAgency() {
		return certificateAgencyRepo.findAll();
	}

	@Override
	public Optional<CertificateAgency> getById(String _id) {
		Optional<CertificateAgency> optionalAgency = Optional.of(new CertificateAgency());
		try {
			CertificateAgency saveAgency = certificateAgencyRepo.findByAgencyid(_id);
			optionalAgency= certificateAgencyRepo.findById(saveAgency.get_id());
			return optionalAgency;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return optionalAgency;
	}

	@Override
	public CertificateAgency saveAgency(CertificateAgency a) {
		try {
			return certificateAgencyRepo.save(a);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public CertificateAgency updateAgency(CertificateAgency a) {
		try {
			return certificateAgencyRepo.save(a);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteAgency(String _id) {
		CertificateAgency c = certificateAgencyRepo.findByAgencyid(_id);
		//Optional<CertificateAgency> optionalAgency = certificateAgencyRepo.findById(c.get_id());
		try {
			if(c!=null)
				certificateAgencyRepo.deleteById(c.get_id());
		} catch (EmptyResultDataAccessException ex) {
			throw new MyNotFoundException("Agency not found");
		}
	}
	
// 	public CertificateAgency getById(String id){
// 		CertificateAgency _id = certificateAgencyRepo.findByAgencyid(id);
// 		return certificateAgencyRepo.findById(_id.get_id()).get();
// 	}
	
// 	public String saveAgency(CertificateAgency a) {
// 		CertificateAgency id = certificateAgencyRepo.findByAgencyid(a.getAgencyid());
// 		if(id==null)
// 		{
// 			certificateAgencyRepo.save(a);
// 			return "Agency details saved successfully : "+a.get_id();
// 	    }
// 		else
// 		{
// 			return "Agency details doesn't exists";
// 		}
// 	}
	
// 	public String updateAgency(CertificateAgency a) {
// 		CertificateAgency id = certificateAgencyRepo.findByAgencyid(a.getAgencyid());
// 		if(id!=null)
// 		{
// 			certificateAgencyRepo.save(a);
// 			return "Agency details updated successfully : "+id.get_id();
// 	    }
// 		else
// 		{
// 			return "Agency details doesn't exists";
// 		}
// 	}
	
// 	public String deleteAgency(String id) {
// 		CertificateAgency _id = certificateAgencyRepo.findByAgencyid(id);
// 		if(_id!=null)
// 		{
// 			certificateAgencyRepo.deleteById(_id.get_id());
// 			return "Agency details deleted successfully : "+_id.get_id();
// 	    }
// 		else
// 		{
// 			return "Agency details doesn't exists";
// 		}
// 	}
	
// @Override
// 	public List<CertificateAgency> getAllAgency() {
// 		return certificateAgencyRepo.findAll();
// 	}
}
