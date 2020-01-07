package com.deloitte.ecommerce.dao;

import java.util.*;
import org.cap.entities.Employee;


public interface ICustomerWalletDao {
	
	Map<Integer,Empolyee> store = new HashMap<>();
	
	public void  findById(int id) {
		Empoloyee e = store.get(id);
		if(id<0) {
			throw IncorrectIdException("Id is not correct !!!");
		}
		
	}
	boolean credentialsCorrect(String mobileno, String password);

}
