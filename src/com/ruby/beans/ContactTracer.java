package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ContactTracer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int centerID;
	private String password;
	private String surname;
	private Timestamp regDate;
	private int contactTracerID;
	private String status;

	public ContactTracer() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCenterID() {
		return centerID;
	}

	public void setCenterID(int centerID) {
		this.centerID = centerID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getContactTracerID() {
		return contactTracerID;
	}

	public void setContactTracerID(int contactTracerID) {
		this.contactTracerID = contactTracerID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
