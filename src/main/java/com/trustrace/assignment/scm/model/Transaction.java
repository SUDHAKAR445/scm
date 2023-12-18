package com.trustrace.assignment.scm.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private String _id;

    @Field("transactionID")
    private String transactionID;

    @Field("product")
    private String product;

    @Field("quantity")
    private String quantity;

    @DocumentReference(collection = "account")
    @Field("sellerID")
    private Account sellerID;

    @DocumentReference(collection = "account")
    @Field("buyerID")
    private Account buyerID;

    @Field("shipdate")
    private Date shipDate;

    @Field("arrivalDate")
    private Date arrivalDate;

    @DocumentReference(collection = "orderDetails")
    @Field("orderID")
    private OrderDetails orderID;

    @DocumentReference(collection = "rawMaterial")
    @Field("rawMaterialReference")
    private ArrayList<RawMaterial> rawMaterialReference;

    @DocumentReference(collection = "production")
    @Field("productionReference")
    private ArrayList<Production> productionReference;
}
