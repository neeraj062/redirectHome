package com.deloitte.telcom.entities;

public class CustomerAccount {
	private String mobileNo;
	private String name;
	private String accountType;
	private double initialBalance;
	
	
	public CustomerAccount() {
		super();
	}


	public CustomerAccount(String mobileNo, String name, String accountType, double initialBalance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.accountType = accountType;
		this.initialBalance = initialBalance;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getName() {
		return name;
	}


	public void setBalance(String name) {
		this.name = name;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getInitialBalance() {
		return initialBalance;
	}


	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	
	public void addBalance(double initialBalance) {
		this.initialBalance+=initialBalance;
	}
	@Override
	public String toString() {
		return "CustomerAccount [mobileNo=" + mobileNo + ", name=" + name + ", accountType=" + accountType
				+ ", initialBalance=" + initialBalance + "]";
	}


	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null || !(obj instanceof CustomerAccount))
			return false;
		CustomerAccount c =(CustomerAccount)obj;
		return c.mobileNo.equals(this.mobileNo);
	}
	
	
	
	
	
}
