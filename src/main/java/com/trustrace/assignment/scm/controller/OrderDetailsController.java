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

import com.trustrace.assignment.scm.model.OrderDetails;
import com.trustrace.assignment.scm.service.OrderDetailsService;

@RestController
//base url
@RequestMapping("/orderdetails")
public class OrderDetailsController {
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@GetMapping("/getallorder")
	public ResponseEntity<List<OrderDetails>> readAllOrder()
	{
		try{
			return new ResponseEntity<List<OrderDetails>>(orderDetailsService.getAllOrder(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/orderbyid/{id}")
	public ResponseEntity<OrderDetails> getById(@PathVariable("id") String id){
		try{
			return new ResponseEntity<>(orderDetailsService.getById(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> createAccount(@RequestBody OrderDetails a)
	{
		try{
			return new ResponseEntity<String>(orderDetailsService.saveOrder(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderDetails a) {
		try{
			return new ResponseEntity<>(orderDetailsService.updateOrder(a),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/orderbyid/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try{
			return new ResponseEntity<>(orderDetailsService.deleteOrder(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Internal Error",HttpStatus.BAD_REQUEST);
		}
	}
	
}
