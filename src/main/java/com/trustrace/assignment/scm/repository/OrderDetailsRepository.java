package com.trustrace.assignment.scm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.trustrace.assignment.scm.model.OrderDetails;


@Repository
public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String>{
    OrderDetails findByOrderID(String orderID);
}
