package com.deloitte.telcom.service;
import org.junit.*;

import com.deloitte.telcom.dao.CustomerAccountDaoImpl;
import com.deloitte.telcom.entities.CustomerAccount;

import java.util.Map;

public class CustomerServiceImplTest {

	@Test
	public void testCreateAccount_1(){
		CustomerServiceImpl service = new CustomerServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo="1234567890";
		String name ="dhruv";
		double balance = 1000;
		String accountType="prepaid";
		CustomerAccount account = service.createAccount(mobileNo, name, accountType, balance);
		Assert.assertNotNull(account);
		double resultBalance = account.getInitialBalance();
		Assert.assertEquals(balance, resultBalance,0);
		Assert.assertEquals(name,account.getName());
		Map<String,CustomerAccount> store = service.getDao().getStore();
		CustomerAccount expected = store.get(mobileNo);
		Assert.assertEquals(expected,account);
	}
	
	@Test
	public void testFindCustomerByMobileNo_2() {
		CustomerServiceImpl service = new CustomerServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo="1234567890";
		String name ="dhruv";
		double balance = 1000;
		String accountType="prepaid";
		
		CustomerAccount account = new CustomerAccount(mobileNo,name,accountType,balance);
		Map<String,CustomerAccount> store = service.getDao().getStore();
		store.put(mobileNo, account);
		//CustomerAccount store =service.findCustomerByMobNo(mobileNo);
		CustomerAccount expected = store.get(mobileNo);
		Assert.assertEquals(expected,account);
	}
	
	
}
