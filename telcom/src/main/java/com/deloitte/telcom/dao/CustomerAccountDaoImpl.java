package com.deloitte.telcom.dao;

import java.util.*;

import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exceptions.CustomerAccountNotFoundException;
public class CustomerAccountDaoImpl implements ICustomerAccountDao{
	Map<String,CustomerAccount> store = new HashMap<>();
	
	@Override
	public void addCustomer(CustomerAccount c) {
		store.put(c.getMobileNo(), c);
	}
	
	@Override
	public Map<String,CustomerAccount> getStore() {
		return store;
	}
	
	@Override
	public CustomerAccount findCustomerByMobNo(String mobNo) {
		CustomerAccount cust = store.get(mobNo);
		if(mobNo==null) {
			throw new CustomerAccountNotFoundException("Please Create Account First with is Mobile No -->"+mobNo);
		}
		return cust;
	}
	
	
	@Override
	public void rechargeAccount(CustomerAccount ac,double addBalance) {
		ac.addBalance(addBalance);
	}
}
