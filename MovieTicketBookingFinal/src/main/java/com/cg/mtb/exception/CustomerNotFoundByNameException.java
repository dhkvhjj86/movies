package com.cg.mtb.exception;

public class CustomerNotFoundByNameException extends RuntimeException  {
	public CustomerNotFoundByNameException(String message){
		super(message);
	}

}