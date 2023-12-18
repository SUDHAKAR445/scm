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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustrace.assignment.scm.model.Account;
import com.trustrace.assignment.scm.service.AccountService;

@RestController
//base url
@RequestMapping("/account")
public class AccountController 
{
	@Autowired
	AccountService accountService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
	
	@GetMapping("/getallaccount")
	public ResponseEntity<List<Account>> readAllAccount()
	{
		try{
			return new ResponseEntity<List<Account>>(accountService.getAllAccount(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/accountbyid/{id}")
	public ResponseEntity<Account> getById(@PathVariable("id") String id){
		try{
		    return new ResponseEntity<>(accountService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAccount(@RequestBody Account account)
	{
		try{
			return new ResponseEntity<String>(accountService.saveAccount(account),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Account a) {
		try{
			return new ResponseEntity<String>(accountService.updateAccount(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/accountbyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<String>(accountService.deleteAccount(id),HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/account-name")
	public ResponseEntity<String> updateName(@RequestParam String id, @RequestParam String newName) {
		try{
			return new ResponseEntity<String>(accountService.updateAccountName(id,newName),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
}
