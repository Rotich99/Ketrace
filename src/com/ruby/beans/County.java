package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class County implements Serializable {
	private static final long serialVersionUID = 1L;
	private int countyID;
	private String county;

	public County() {
		super();
	}

	public int getCountyID() {
		return countyID;
	}

	public void setCountyID(int countyID) {
		this.countyID = countyID;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

}
