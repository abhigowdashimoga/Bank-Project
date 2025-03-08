package com.example.demo.Exception;

public class CustomerAlreadyExists extends RuntimeException{
	
	public CustomerAlreadyExists(String msg) {
		super(msg);
	}

}
