package com.changebill.exception;


public class ChangeBillException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ChangeBillException(String errorMessage) {

		super(errorMessage);
	}

}
