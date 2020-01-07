package com.deloitte.telcom.dao;

import java.util.Map;

import com.deloitte.telcom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	void addCustomer(CustomerAccount c);
	CustomerAccount findCustomerByMobNo(String mobNo);
	void rechargeAccount(CustomerAccount ac,double addBalance);
	Map<String,CustomerAccount> getStore();
	//Set<CustomerAccount> allCustomers();
}
