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

import com.trustrace.assignment.scm.model.Transaction;
import com.trustrace.assignment.scm.service.TransactionService;

@RestController
//base url
@RequestMapping("/transaction/")
public class TransactionController {
     @Autowired
	TransactionService transactionService;
	
	@GetMapping("/getalltransaction")
	public ResponseEntity<List<Transaction>> readAllTransaction()
	{
		try{
			return new ResponseEntity<List<Transaction>>(transactionService.getAllTransaction(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/transactionbyid/{id}")
	public ResponseEntity<Transaction> getById(@PathVariable("id") String id){
		try{
			return new ResponseEntity<>(transactionService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createTransaction(@RequestBody Transaction a)
	{
		try{
			return new ResponseEntity<String>(transactionService.saveTransaction(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Transaction a) {
		try{
			return new ResponseEntity<>(transactionService.updateTransaction(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/agencybyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(transactionService.deleteTransaction(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
