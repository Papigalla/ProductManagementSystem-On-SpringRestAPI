package com.example.Product_Management_System.util;

import com.example.Product_Management_System.entity.Product;
import com.example.Product_Management_System.util.ResponseStructure;

public class ResponseStructure<T> {
	private int value;
	private String message;
	private T data;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static<T> ResponseStructure<T> create(int value,String message,T data)
	{
		ResponseStructure<T> response=new ResponseStructure<T>();
		response.setValue(value);
		response.setMessage(message);
		response.setData(data);
		return response;
	}

	

}
