package com.trustrace.assignment.scm.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="account")
public class Account{
	
	public static final String HttpStatus = null;

	@Id
	private String _id;
	
	@Field("brandid")
	private String brandid;

	@Field("name")
	private String name;
	
	@Field("type")
	private String type;
	
	@Field("tier")
	private String tier;
	
	@Field("productName")
	private String productName;
	
	@Field("sustainabilityRating")
	private Integer sustainabilityRating;
	
	@Field("countryOrigin")
	private String countryOrigin;
	
	@Field("certifictaions")
	// @DocumentReference(collection = "certificateDetails")
	private List<String> certifications;
	
	@Field("contact")
	private Supp contact;
	
	@Field("supplier")
	//@DocumentReference(collection = "supplier")
	private List<String> supplier;
	
	@Field("brand")
	//@DocumentReference(collection = "account")
	private List<String> brand;
	
	@Field("productCategories")
	private List<String> productCategories;	
		
	@Data	 
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Supp
	{
		String street;
		String city;
		String state;
		String phone;
	}
}
