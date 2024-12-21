package com.example.Product_Management_System.exception;

public class ProductNotFoundById extends RuntimeException{
	private String message;

	public ProductNotFoundById(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
