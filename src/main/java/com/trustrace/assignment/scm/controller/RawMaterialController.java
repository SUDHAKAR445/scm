package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.RawMaterial;
import com.trustrace.assignment.scm.service.RawMaterialService;

@RestController
//base url
@RequestMapping("/rawmaterial/")
public class RawMaterialController {
    @Autowired
	RawMaterialService rawMaterialService;
	
	@GetMapping("/getallrawmaterial")
	public ResponseEntity<List<RawMaterial>> readAllRawMaterial()
	{
		try{
			return new ResponseEntity<List<RawMaterial>>(rawMaterialService.getAllRawMaterial(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/rawmaterialbyid/{id}")
	public ResponseEntity<RawMaterial> getById(@PathVariable("id") String id){
		try{
			return new ResponseEntity<>(rawMaterialService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createRawMaterial(@RequestBody RawMaterial a)
	{
		try{
			return new ResponseEntity<String>(rawMaterialService.saveRawMaterial(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody RawMaterial a) {
		try{
			return new ResponseEntity<>(rawMaterialService.updateRawMaterial(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/rawmaterialbyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(rawMaterialService.deleteRawMaterial(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
}
