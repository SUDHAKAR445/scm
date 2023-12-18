package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.OrderDetails;
import com.trustrace.assignment.scm.repository.OrderDetailsRepository;
import com.trustrace.assignment.scm.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImp implements OrderDetailsService{
	@Autowired
	OrderDetailsRepository orderDetailsRepo;
	
	
	public OrderDetails getById(String id){
		return orderDetailsRepo.findById(id).get();
	}
	
	public String saveOrder(OrderDetails a) {
		OrderDetails id = orderDetailsRepo.findByOrderID(a.getOrderID());
		if(id==null)
		{
			orderDetailsRepo.save(a);
			return "OrderDetails saved successfully : "+a.get_id();
	    }
		else
		{
			return "OrderDetails already exists";
		}
	}
	
	public String updateOrder(OrderDetails a) {
		OrderDetails id = orderDetailsRepo.findByOrderID(a.getOrderID());
		if(id!=null)
		{
			orderDetailsRepo.save(a);
			return "OrderDetails Updated successfully : "+id.get_id();
	    }
		else
		{
			return "OrderDetails doesn't exists";
		}
	}
	
	public String deleteOrder(String id) {
		OrderDetails _id = orderDetailsRepo.findByOrderID(id);
		if(_id!=null)
		{
			orderDetailsRepo.deleteById(_id.get_id());
			return "OrderDetails deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "OrderDetails doesn't exists";
		}
	}
	
	@Override
	public List<OrderDetails> getAllOrder() {
		return orderDetailsRepo.findAll();
	}
	
}
