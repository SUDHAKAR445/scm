package com.trustrace.assignment.scm.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.trustrace.assignment.scm.model.Production;

public interface ProductionService {
    List<Production> getAllProduction();
	
	Production getById(String _id) throws IOException;
	
	String saveProductionWithImage(Production a, MultipartFile file) throws IOException;

	String updateImageById(String id, MultipartFile file) throws IOException;
	
	String updateProduction(Production a);
	
	String deleteProduction(String id);

	byte[] getImageById(String id) throws Exception;
}
