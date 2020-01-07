package com.deloitte.telcom.service;

import java.util.Map;

import com.deloitte.telcom.entities.*;

public interface ICustomerService {
	CustomerAccount createAccount(String mobNo,String name,String AccType,double bal);
	CustomerAccount findCustomerByMobNo(String mobNo);
	void rechargeAccount(CustomerAccount ac,double addBalance);
	
}
