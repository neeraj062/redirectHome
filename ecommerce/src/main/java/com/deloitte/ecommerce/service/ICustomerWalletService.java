package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNoException;

public interface ICustomerWalletService {
	
	boolean credentialsCorrect(String mobileno, String name);
	
	CustomerWallet  findByMobileNo(String no) throws IncorrectMobileNoException;
	

}
