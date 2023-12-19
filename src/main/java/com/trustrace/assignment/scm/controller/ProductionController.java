package com.trustrace.assignment.scm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.model.Production;
import com.trustrace.assignment.scm.service.ProductionService;

@RestController
//base url
@RequestMapping("/production/")
public class ProductionController {
     @Autowired
	ProductionService productionService;
	
	@GetMapping("/getallproduction")
	public ResponseEntity<List<Production>> readAllProduction()
	{
		try{
			return new ResponseEntity<List<Production>>(productionService.getAllProduction(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/getImageById/{id}")

	public ResponseEntity<?> getImageById(@PathVariable("id") String id) throws Exception
	{
		byte[] image = productionService.getImageById(id);

		return ResponseEntity.status(HttpStatus.OK)
			.contentType(MediaType.valueOf("image/png"))
			.body(image);
	} 
	
	@GetMapping("/select/productionbyid/{id}")
	public ResponseEntity<Production> getById(@PathVariable("id") String id) throws IOException{
			try 
		{
            
            return ResponseEntity.ok(productionService.getById(id));
        } catch (Exception e) 
		{
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createProduction(@ModelAttribute Production a,@RequestParam MultipartFile file)
	{
		try 
		{
            
            return ResponseEntity.ok(productionService.saveProductionWithImage(a, file));
        } catch (Exception e) 
		{
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred during production upload");
        }
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Production a) {
		try{
			return new ResponseEntity<>(productionService.updateProduction(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateimage/{id}")
	public ResponseEntity updateImageById(@RequestParam String id, @RequestParam MultipartFile file) 
	{
		try 
		{
            productionService.updateImageById(id, file);
            return ResponseEntity.ok("Production saved successfully with image");
        } catch (Exception e) 
		{
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred during production  upload");
        }
	}
	
	@DeleteMapping("/delete/productionbyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(productionService.deleteProduction(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
