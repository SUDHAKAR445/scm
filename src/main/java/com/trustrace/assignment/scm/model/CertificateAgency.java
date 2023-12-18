package com.trustrace.assignment.scm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="certificateAgency")
@Builder
public class CertificateAgency {
	
	@Id
	private String _id;
	
	@Field("agencyid")
	private String agencyid;

	@Field("name")
	private String name;
	
	@Field("contanctPerson")
	private String contactPerson;
	
	@Field("emailId")
	private String emailId;
	
	@Field("phone")
	private String phone;

    public Object map(Object object) {
        return null;
    }

}
