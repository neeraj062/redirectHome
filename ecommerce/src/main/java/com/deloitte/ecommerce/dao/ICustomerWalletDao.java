package com.deloitte.ecommerce.dao;


import com.deloitte.ecommerce.entities.CustomerWallet;


public interface ICustomerWalletDao {
	
	
	CustomerWallet  findByMobileNo(String id);
	
	boolean credentialsCorrect(String mobileno, String password);

}
