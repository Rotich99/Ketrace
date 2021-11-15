package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class TraceOperation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String subject;
	private int operationID;
	private int contactTracerID;
	private int alertID;
	private String updates;
	private int status;

	public TraceOperation() {
		super();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getOperationID() {
		return operationID;
	}

	public void setOperationID(int operationID) {
		this.operationID = operationID;
	}

	public int getContactTracerID() {
		return contactTracerID;
	}

	public void setContactTracerID(int contactTracerID) {
		this.contactTracerID = contactTracerID;
	}

	public int getAlertID() {
		return alertID;
	}

	public void setAlertID(int alertID) {
		this.alertID = alertID;
	}

	public String getUpdates() {
		return updates;
	}

	public void setUpdates(String updates) {
		this.updates = updates;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
