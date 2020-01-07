package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.dao.ICustomerWalletDao;
import com.deloitte.ecommerce.entities.CustomerWallet;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNoException;
import com.deloitte.ecommerce.exceptions.InsufficientBalanceException;

public class CustomerWalletServiceImpl implements ICustomerWalletService{
	
	private ICustomerWalletDao dao;
	
	public CustomerWalletServiceImpl(ICustomerWalletDao dao) {
		this.dao=dao;
	}

	

	@Override
	public CustomerWallet findByMobileNo(String no)throws IncorrectMobileNoException {
		if(no==null || no.length()!=10)
		{
			throw new IncorrectMobileNoException("Mobile no is incorrect.");
		}
		CustomerWallet c=dao.findByMobileNo(no);
		return c;
	}



	@Override
	public boolean credentialsCorrect(String mobileno, String password) {
		return dao.credentialsCorrect(mobileno, password);
	}


}
