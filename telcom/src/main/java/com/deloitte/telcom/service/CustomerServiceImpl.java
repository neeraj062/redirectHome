package com.deloitte.telcom.service;

//import com.deloitte.telcom.dao.ICustomerAccountDao;
import com.deloitte.telcom.entities.*;
import com.deloitte.telcom.exceptions.*;

import java.util.Map;

import com.deloitte.telcom.dao.*;
import java.util.*;
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerAccountDao dao;
	
	public CustomerServiceImpl(ICustomerAccountDao dao) {
		this.dao=dao;
	}
	
	public CustomerAccount createAccount(String mobNo,String name,String AccType,double bal) {
		CustomerAccount acc = new CustomerAccount(mobNo,name,AccType,bal);
		dao.addCustomer(acc);
		return acc;
	}
	
	public ICustomerAccountDao getDao(){
		return dao;
	}
	
	
	public CustomerAccount findCustomerByMobNo(String mobNo) {
		if(mobNo==null || mobNo.length()!=10) {
			throw new MobileNoNotFoundException("Moble number not found in our Database"+mobNo);
		}
		
		CustomerAccount c = dao.findCustomerByMobNo(mobNo);
		return c;
	}
	
	
	public void rechargeAccount(CustomerAccount ac,double addBalance) {
		dao.rechargeAccount(ac, addBalance);
	}
	
}
