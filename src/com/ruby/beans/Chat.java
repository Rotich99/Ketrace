package com.ruby.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recepientID;
	private int senderID;
	private int chatID;
	private String subject;
	private String message;
	private Timestamp dateSent;
	private int status;

	public Chat() {
		super();
	}

	public int getRecepientID() {
		return recepientID;
	}

	public void setRecepientID(int recepientID) {
		this.recepientID = recepientID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getChatID() {
		return chatID;
	}

	public void setChatID(int chatID) {
		this.chatID = chatID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getDateSent() {
		return dateSent;
	}

	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
