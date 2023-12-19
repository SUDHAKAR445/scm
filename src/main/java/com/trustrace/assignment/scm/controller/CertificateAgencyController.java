package com.trustrace.assignment.scm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.exception.MyNotFoundException;
import com.trustrace.assignment.scm.model.CertificateAgency;
import com.trustrace.assignment.scm.service.CertificateAgencyService;

@RestController
//base url
@RequestMapping("api/agency")
public class CertificateAgencyController {
	@Autowired
	CertificateAgencyService certificateAgencyService;
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CertificateAgency createAgency(@RequestBody CertificateAgency a) throws Exception{
        return certificateAgencyService.saveAgency(a);
    }
	
	@GetMapping("/getallagency")
	public List<CertificateAgency> readAllAgency()
	{
		return certificateAgencyService.getAllAgency();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CertificateAgency> getById(@PathVariable("id") String id){
		return certificateAgencyService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id){

        try {
            certificateAgencyService.deleteAgency(id);
            return ResponseEntity.ok().build();
        } catch (MyNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }

    }
	// @PostMapping("/save")
	// public ResponseEntity<String> createAgency(@RequestBody CertificateAgency account)
	// {
	// 	try{
	// 		return new ResponseEntity<String>(certificateAgencyService.saveAgency(account),HttpStatus.OK);
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
	// 	}
	// }
	
	// @PutMapping("/update")
	// public ResponseEntity<String> update(@RequestBody CertificateAgency a) {
	// 	try{
	// 		return new ResponseEntity<>(certificateAgencyService.updateAgency(a),HttpStatus.OK);
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
	// 	}
	// }
	
	// @DeleteMapping("/delete/agencybyid/{id}")
	// public ResponseEntity<String> delete(@PathVariable("id") String id) {
	// 	try{
	// 		return new ResponseEntity<>(certificateAgencyService.deleteAgency(id),HttpStatus.OK);
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
	// 	}
	// }
	
}
