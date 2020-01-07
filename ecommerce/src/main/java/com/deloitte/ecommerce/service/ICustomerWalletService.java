package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNoException;

public interface ICustomerWalletService {
	
	boolean credentialsCorrect(int id, String name);
	
	Employee findById(int no) throws IncorrectMobileNoException;
	

}
