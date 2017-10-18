package com.spring.model;

public class User {
	
	private String name;
	private long id;
	
	public User() {
		
	}
	public User(String s,long id) {
		this.name = s;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(long Id) {
		this.id = Id;
	}

}
