package com.trustrace.assignment.scm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Production {
    @Id
    private String _id;

    @Field("productionID")
    private String productionID;
    
    @Field("product")
    private String product;

    @Field("quantityProduced")
    private String quantityProduced;

    @Field("buyerID")
    private String buyerID;

    @Field("timestamp")
    private String timestamp;

    @Field("image_url")
    private String image_url;

    @Transient
    @JsonIgnore
    private byte[] code;
}
