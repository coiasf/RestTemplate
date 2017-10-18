package com.spring.main;

public class ResponseWrapper<T> {
	T response;
	
	public ResponseWrapper() {
		
	}
	public T getResponse() {
		return response;
	}
	
	public void setResponse(T response) {
		this.response = response;
	}
	
	

}
