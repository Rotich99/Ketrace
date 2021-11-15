package com.ruby.beans;

import java.io.Serializable;

public class UserLogin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private int IDNo;
	private String type;

	public UserLogin() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIDNo() {
		return IDNo;
	}

	public void setIDNo(int iDNo) {
		IDNo = iDNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
