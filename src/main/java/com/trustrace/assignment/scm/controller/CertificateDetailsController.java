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

import com.trustrace.assignment.scm.model.CertificateDetails;
import com.trustrace.assignment.scm.service.CertificateDetailsService;

@RestController
//base url
@RequestMapping("/certificatedetails/")
public class CertificateDetailsController {
	@Autowired
	CertificateDetailsService certificateDetailsService;
	
	@GetMapping("/select")
	public ResponseEntity<List<CertificateDetails>> getAllCertificateDetails(){
		try{
			return new ResponseEntity<>(certificateDetailsService.getAllCertificate(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/certificatebyid/{id}")
	public ResponseEntity<CertificateDetails> getById(@PathVariable("id") String id){
		try{
			return new ResponseEntity<>(certificateDetailsService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> insert(@RequestBody CertificateDetails a) {
		try{
			return new ResponseEntity<>(certificateDetailsService.saveCertificate(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CertificateDetails a) {
		try{
			return new ResponseEntity<>(certificateDetailsService.updateCertificate(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/certificatebyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(certificateDetailsService.deleteCertificate(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
}
