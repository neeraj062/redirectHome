package com.deloitte.ecommerce.entities;

public class CustomerWallet {

	private String mobileNo;
	private String password;
	private String name;
	private double balance;


	public CustomerWallet(String mobileNo, String password, String name, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void addBalance(double balance) {
		this.balance += balance;
	}
	
	
	@Override
	public String toString() {
		return "CustomerWallet [mobileNo=" + mobileNo + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return  mobileNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			{
			return true;
			}
		if (obj == null || !(obj instanceof CustomerWallet))
			{
			return false;
			}
		CustomerWallet c = (CustomerWallet) obj;
		return c.getMobileNo().equals(this.mobileNo);
	}

}
