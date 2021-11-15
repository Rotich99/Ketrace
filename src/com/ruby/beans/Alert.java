package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;
	private Timestamp dateRecorded;
	private int testOfficerID;
	private int locationID;			//CountyID
	private float temperature;
	private int descriptionAge;
	private int alertID;
	private int id;
	private String preciseLocation;
	
	private String county;
	private TestOfficer reporter;

	public Alert() {
		super();
	}

	public Timestamp getDateRecorded() {
		return dateRecorded;
	}

	public void setDateRecorded(Timestamp dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public int getTestOfficerID() {
		return testOfficerID;
	}

	public void setTestOfficerID(int testOfficerID) {
		this.testOfficerID = testOfficerID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public int getDescriptionAge() {
		return descriptionAge;
	}

	public void setDescriptionAge(int descriptionAge) {
		this.descriptionAge = descriptionAge;
	}

	public int getAlertID() {
		return alertID;
	}

	public void setAlertID(int alertID) {
		this.alertID = alertID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreciseLocation() {
		return preciseLocation;
	}

	public void setPreciseLocation(String preciseLocation) {
		this.preciseLocation = preciseLocation;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public TestOfficer getReporter() {
		return reporter;
	}

	public void setReporter(TestOfficer reporter) {
		this.reporter = reporter;
	}

}
