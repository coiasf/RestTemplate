package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;	
	
	public User(String name) {
		this.name = name;
	}
	
	public User() {
		
	}
	public User(String name,long id) {
		this.name = name;
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
