package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Consent implements Serializable {
	private static final long serialVersionUID = 1L;
	private Timestamp dateRecorded;
	private int locationID;
	private String description;
	private int alertID;
	private int ID;		//Suspect
	private String preciseLocation;
	
	private Citizen citizen;

	public Consent() {
		super();
	}

	public Timestamp getDateRecorded() {
		return dateRecorded;
	}

	public void setDateRecorded(Timestamp dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAlertID() {
		return alertID;
	}

	public void setAlertID(int alertID) {
		this.alertID = alertID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getPreciseLocation() {
		return preciseLocation;
	}

	public void setPreciseLocation(String preciseLocation) {
		this.preciseLocation = preciseLocation;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}
