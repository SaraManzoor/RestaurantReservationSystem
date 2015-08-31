package com.example.exception;

public class AppException extends Exception{
	
	
	public AppException(){
		
	}
	
	public AppException(String msg){
		super(msg);
	}

	public AppException(String msg, Throwable cause){
		super(msg, cause);
	}
}
