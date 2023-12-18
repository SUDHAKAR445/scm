package com.trustrace.assignment.scm.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="certificateDetails")
public class CertificateDetails 
{
	@Id
	private String _id;
	
	@Field("certificateID")
	private String certificateID;
	
	@Field("agencyid")
	@DocumentReference(collection = "certificateAgency")
	private CertificateAgency agencyID;
	
	@Field("name")
	private String name;
	
	@Field("certificateStatus")
	private String certificateStatus;
	
	@Field("certificateDate")
	private Date certificateDate;
	
	@Field("facilities")
	private ArrayList<String> facilities;
	
}
