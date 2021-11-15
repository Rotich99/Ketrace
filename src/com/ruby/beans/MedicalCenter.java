package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class MedicalCenter implements Serializable {
	private static final long serialVersionUID = 1L;
	private int centerID;
	private int phone;
	private int countyID;
	private String name;
	private String about;
	private String location;
	private String email;

	public MedicalCenter() {
		super();
	}

	public int getCenterID() {
		return centerID;
	}

	public void setCenterID(int centerID) {
		this.centerID = centerID;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getCountyID() {
		return countyID;
	}

	public void setCountyID(int countyID) {
		this.countyID = countyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
