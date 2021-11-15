package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	private Timestamp dateOccured;
	private int countyID;
	private int notificationID;
	private String details;
	
	private County county;

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public Notification() {
		super();
	}

	public Timestamp getDateOccured() {
		return dateOccured;
	}

	public void setDateOccured(Timestamp dateOccured) {
		this.dateOccured = dateOccured;
	}

	public int getCountyID() {
		return countyID;
	}

	public void setCountyID(int countyID) {
		this.countyID = countyID;
	}

	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
