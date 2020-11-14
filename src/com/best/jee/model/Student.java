package com.best.jee.model;

import java.io.Serializable;

public class Student implements Serializable{

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	private String name;
	private String nrc;
	private String address;
	private String rollNo;
	public Student(Long id, String name, String nrc, String address, String rollNo) {
		super();
		this.id = id;
		this.name = name;
		this.nrc = nrc;
		this.address = address;
		this.rollNo = rollNo;
	}
	
	
}
