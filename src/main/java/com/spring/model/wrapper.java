package com.spring.model;

import com.spring.main.ResponseWrapper;

public class wrapper<T> {
	
	private String metadata;
	private T data;
	
	public wrapper(String metadata,T resp) {
		this.metadata = metadata;
		this.data = resp;
	}
	public String getMetadata() {
		return metadata;
	}
	
	public T getData() {
		return data;
	}
}
