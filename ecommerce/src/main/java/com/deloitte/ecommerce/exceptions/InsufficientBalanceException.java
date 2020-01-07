package com.deloitte.ecommerce.exceptions;

public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}

}
