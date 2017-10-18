package com.spring.model;

public class City {
	
	private String name;
	private int id;
	private String zipCode;
	
	public City() {
		
	}
	
	public City(String name,int id,String zipCode) {
		this.name = name;
		this.id = id;
		this.zipCode = zipCode;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int Id) {
		this.id = Id;
	}
	public void setZipCode(String zipcode) {
		this.zipCode = zipcode;
	}

}
