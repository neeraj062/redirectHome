package com.deloitte.telcom.exceptions;

public class CustomerAccountNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAccountNotFoundException(String msg) {
		super(msg);
	}
}
