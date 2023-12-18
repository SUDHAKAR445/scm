package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.RawMaterial;
import com.trustrace.assignment.scm.repository.RawMaterialRepository;
import com.trustrace.assignment.scm.service.RawMaterialService;

@Service
public class RawMaterialServiceImp implements RawMaterialService{
    @Autowired
	RawMaterialRepository rawMaterialRepo;
	
	
	public RawMaterial getById(String id){
		RawMaterial _id = rawMaterialRepo.findByRawMaterialID(id);
		if(_id!=null)
		{
		    return rawMaterialRepo.findById(_id.get_id()).get();
		}
		else
		{
			return null;
		}
	}
	
	public String saveRawMaterial(RawMaterial a) {
		RawMaterial id = rawMaterialRepo.findByRawMaterialID(a.getRawMaterialID());
		if(id==null)
		{
			rawMaterialRepo.save(a);
			return "RawMaterial saved successfully : "+a.get_id();
	    }
		else
		{
			return "RawMaterial already exists : "+id.get_id();
		}
	}
	
	public String updateRawMaterial(RawMaterial a) {
		RawMaterial id = rawMaterialRepo.findByRawMaterialID(a.getRawMaterialID());
		if(id!=null)
		{
			rawMaterialRepo.save(a);
			return "RawMaterial Updated successfully : "+a.get_id();
	    }
		else
		{
			return "RawMaterial doesn't exists ";
		}
	}
	
	public String deleteRawMaterial(String id) {
		RawMaterial _id = rawMaterialRepo.findByRawMaterialID(id);
		if(id!=null)
		{
			rawMaterialRepo.deleteById(_id.get_id());;
			return "RawMaterial Deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "RawMaterial doesn't exists ";
		}
	}
	
	@Override
	public List<RawMaterial> getAllRawMaterial() {
		return rawMaterialRepo.findAll();
	}
	
}
