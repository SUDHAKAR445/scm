package com.trustrace.assignment.scm.service;

import java.util.List;

import com.trustrace.assignment.scm.model.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> getAllOrder();
	
	OrderDetails getById(String _id);
	
	String saveOrder(OrderDetails a);
	
	String updateOrder(OrderDetails a);
	
	String deleteOrder(String id);
}
