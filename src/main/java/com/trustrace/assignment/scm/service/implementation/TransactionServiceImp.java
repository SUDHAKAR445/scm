package com.trustrace.assignment.scm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustrace.assignment.scm.model.Transaction;
import com.trustrace.assignment.scm.repository.TransactionRepository;
import com.trustrace.assignment.scm.service.TransactionService;

@Service
public class TransactionServiceImp implements TransactionService
{
    @Autowired
	TransactionRepository transactionRepo;
	
	
	public Transaction getById(String id){
		Transaction _id = transactionRepo.findByTransactionID(id);
		return transactionRepo.findById(_id.get_id()).get();
	}
	
	public String saveTransaction(Transaction a) {
		Transaction id = transactionRepo.findByTransactionID(a.getTransactionID());
		if(id==null)
		{
			transactionRepo.save(a);
			return "Transaction saved successfully : "+a.get_id();
	    }
		else
		{
			return "Transaction already exists : "+id.get_id();
		}
	}
	
	public String updateTransaction(Transaction a) {
		Transaction id = transactionRepo.findByTransactionID(a.getTransactionID());
		if(id!=null)
		{
			transactionRepo.save(a);
			return "Transaction updated successfully : "+a.get_id();
	    }
		else
		{
			return "Transaction doesn't exists";
		}
	}
	
	public String deleteTransaction(String id) {
		Transaction _id = transactionRepo.findByTransactionID(id);
		if(id!=null)
		{
			transactionRepo.deleteById(_id.get_id());
			return "Transaction deleted successfully : "+_id.get_id();
	    }
		else
		{
			return "Transaction doesn't exists";
		}
	}
	
	@Override
	public List<Transaction> getAllTransaction() {
		return transactionRepo.findAll();
	}
	
}
