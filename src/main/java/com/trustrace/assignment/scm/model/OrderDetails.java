package com.trustrace.assignment.scm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
	@Id
	private String _id;
	
	@Field("orderID")
	private String orderID;
	
	@Field("orderDate")
	private Date orderDate;
	
	@Field("customerID")
	@DocumentReference(collection = "account")
	private Account customerID;
	
	@Field("paymentStatus")
	private String paymentStatus;
	
	@Field("deliveryStatus")
	private String deliveryStatus;
	
	@DocumentReference(collection = "transaction")
	@Field("transactionID")
	private Transaction transactionID;
	
}
