package com.conversion.exception;


public class NumberException extends Exception {
	/**
	 * Custom Base Exception
	 */
	private static final long serialVersionUID = 1L;
	private final int httpstatus;
	private final String message;

	
	public NumberException(String message, int code) {
		this.httpstatus = code;
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}

	public int getCode() {
		return this.httpstatus;
	}

}
