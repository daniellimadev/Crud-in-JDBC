package com.contact.model;

import java.util.Date;

public class Contact {

	private int id;
	private String name;
	private int age;
	private Date dateregister;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateregister() {
		return dateregister;
	}
	public void setDateregister(Date dateregister) {
		this.dateregister = dateregister;
	}
}
