package com.trustrace.assignment.scm.service.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trustrace.assignment.scm.model.Production;
import com.trustrace.assignment.scm.repository.ProductionRepository;
import com.trustrace.assignment.scm.service.ProductionService;

@Service
public class ProductionServiceImp implements ProductionService {
    @Autowired
	ProductionRepository productionRepo;
	
	private final String FOLDER_PATH = "C:/Users/Sudhakar/java/scm/src/main/resources/images/";
	private String imageUrlGenerator(MultipartFile file) throws IOException
	{
		String url = FOLDER_PATH + file.getOriginalFilename();
		file.transferTo(new File(url));
		return url;
	}

	public byte[] getImageById(String id)
	{
		try {
			Production _id = productionRepo.findByProductionID(id);
			if(_id!=null)
			{
				byte[] images = Files.readAllBytes(new File(_id.getImage_url()).toPath());
				return images;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Production getById(String id) {
		try {
			Production _id = productionRepo.findByProductionID(id);
			return _id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String saveProductionWithImage(Production a, MultipartFile file) throws IOException {
		Production id = productionRepo.findByProductionID(a.getProductionID());
		if(id==null)
		{
			Production production = new Production(
				null, 
				a.getProductionID(),
				a.getProduct(),
				a.getQuantityProduced(), 
				a.getBuyerID(), 
				a.getTimestamp(), 
				a.getImage_url(),
				null
			);
			production.setImage_url(imageUrlGenerator(file));
			productionRepo.save(production);
			return "Production saved successfully : "+a.get_id();
        }
		else
		{
			return "Production already exists";
		}
	}
	
	public String updateProduction(Production a) {
		Production id = productionRepo.findByProductionID(a.getProductionID());
		if(id!=null)
		{
			productionRepo.save(a);
			return "Production updated successfully : "+id.get_id();
	    }
		else
		{
			return "Production doesn't exists";
		}
	}
	
	public String deleteProduction(String id) {
		Production _id = productionRepo.findByProductionID(id);
		if(id!=null)
		{
			productionRepo.deleteById(_id.get_id());
			return "Production deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "Production doesn't exists";
		}
	}
	
	public List<Production> getAllProduction() {
		return productionRepo.findAll();
	}

	@Override
	public String updateImageById(String id, MultipartFile file) throws IOException {
		Production _id = productionRepo.findByProductionID(id);
		if(id!=null)
		{
			_id.setImage_url(imageUrlGenerator(file));
			productionRepo.save(_id);
			return "Production Image updated successfully : "+_id.get_id();
	    }
		else
		{
			return "Production doesn't exists";
		}
	}
}
