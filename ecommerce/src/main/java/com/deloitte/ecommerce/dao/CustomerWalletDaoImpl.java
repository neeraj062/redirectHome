package com.deloitte.ecommerce.dao;

import java.util.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.ecommerce.entities.CustomerWallet;

import com.deloitte.ecommerce.exceptions.CustomerWalletNotFoundException;


public class CustomerWalletDaoImpl implements ICustomerWalletDao{
	
	Map<String,CustomerWallet> store=new HashMap<>();
	
	public  CustomerWalletDaoImpl() {
		CustomerWallet c1 = new CustomerWallet("1234567890", "1234", "Dhruv", 1009900);
        store.put(c1.getMobileNo(), c1);
        CustomerWallet c2= new CustomerWallet("999999999", "5555", "Neeraj", 299900);
        store.put(c2.getMobileNo(), c2);
	} 
        
    
	@Override
	public CustomerWallet findByMobileNo(String no) {
		CustomerWallet c=store.get(no);
		if(c==null)
		{
			throw new CustomerWalletNotFoundException("Customer Wallet not found for mobile no="+no);
		}
		return c;
	}

	@Override
    public boolean credentialsCorrect(String mobileno, String password) {
        CustomerWallet user = store.get(mobileno);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
		
		
	

}
