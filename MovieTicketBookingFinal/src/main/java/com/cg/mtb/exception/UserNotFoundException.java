package com.cg.mtb.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message){
		super(message);
	}
}