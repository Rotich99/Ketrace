package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Place implements Serializable {
	private static final long serialVersionUID = 1L;
	private int countyID;
	private int placeID;
	private String place;

	public Place() {
		super();
	}

	public int getCountyID() {
		return countyID;
	}

	public void setCountyID(int countyID) {
		this.countyID = countyID;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
