package com.ruby.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ruby.beans.*;

public class DBUpdate {
	public static void updateCitizen(Connection con, Citizen c) throws SQLException {
		String query = "UPDATE CITIZENS SET FIRST_NAME=?, LAST_NAME=?, PASSWORD=?, PHONE=?, ID_NO=?, EMAIL=? WHERE ID_NO=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, c.getFirstName());
			pst.setString(2, c.getLastName());
			pst.setString(3, c.getPassword());
			pst.setInt(4, c.getPhone());
			pst.setInt(5, c.getIDNo());
			pst.setString(6, c.getEmail());
			pst.setInt(7, c.getIDNo());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTestOfficer(Connection con, TestOfficer t) throws SQLException {
		String query = "UPDATE TEST_OFFICER SET FIRST_NAME=?, LAST_NAME=?, PASSWORD=?, NATIONAL_ID=?, COUNTY_ID=?, REG_DATE=?, LOCATION=?, COMPANY=? WHERE NATIONAL_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, t.getFirstName());
			pst.setString(2, t.getLastName());
			pst.setString(3, t.getPassword());
			pst.setInt(4, t.getNationalID());
			pst.setInt(5, t.getCountyID());
			pst.setDate(6, t.getRegDate());
			pst.setString(7, t.getLocation());
			pst.setString(8, t.getCompany());
			pst.setInt(9, t.getNationalID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateAlert(Connection con, Alert a) throws SQLException {
		String query = "UPDATE ALERT SET DATE_RECORDED=?, TEST_OFFICER_ID=?, LOCATION_ID=?, TEMPERATURE=?, DESCRIPTION_AGE=?, ALERT_ID=?, ID=?, PRECISE_LOCATION=? WHERE ALERT_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setTimestamp(1, a.getDateRecorded());
			pst.setInt(2, a.getTestOfficerID());
			pst.setInt(3, a.getLocationID());
			pst.setFloat(4, a.getTemperature());
			pst.setInt(5, a.getDescriptionAge());
			pst.setInt(6, a.getAlertID());
			pst.setInt(7, a.getId());
			pst.setString(8, a.getPreciseLocation());
			pst.setInt(9, a.getAlertID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateAssociateTraceContact(Connection con, AssociateTraceContact a) throws SQLException {
		String query = "UPDATE ASSOCIATE_TRACE_CONTACT SET CONTACT_ID=?, PHONE=?, COUNTY_ID=?, FULL_NAME=?, LOCATION=?, COMMENT=?, ID_NO=?, STATUS=? WHERE CONTACT_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, a.getContactID());
			pst.setInt(2, a.getPhone());
			pst.setInt(3, a.getCountyID());
			pst.setString(4, a.getFullName());
			pst.setString(5, a.getLocation());
			pst.setString(6, a.getComment());
			pst.setInt(7, a.getIdNo());
			pst.setInt(8, a.getStatus());
			pst.setInt(9, a.getContactID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateChat(Connection con, Chat c) throws SQLException {
		String query = "UPDATE CHATS SET RECEPIENT_ID=?, SENDER_ID=?, CHAT_ID=?, SUBJECT=?, MESSAGE=?, DATE_SENT=?, STATUS=? WHERE CHAT_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, c.getRecepientID());
			pst.setInt(2, c.getSenderID());
			pst.setInt(3, c.getChatID());
			pst.setString(4, c.getSubject());
			pst.setString(5, c.getMessage());
			pst.setTimestamp(6, c.getDateSent());
			pst.setInt(7, c.getStatus());
			pst.setInt(8, c.getChatID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateConsent(Connection con, Consent c) throws SQLException {
		String query = "UPDATE CONSENT SET DATE_RECORDED=?, LOCATION_ID=?, DESCRIPTION=?, ALERT_ID=?, ID=?, PRECISE_LOCATION=? WHERE ALERT_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setTimestamp(1, c.getDateRecorded());
			pst.setInt(2, c.getLocationID());
			pst.setString(3, c.getDescription());
			pst.setInt(4, c.getAlertID());
			pst.setInt(5, c.getID());
			pst.setString(6, c.getPreciseLocation());
			pst.setInt(7, c.getAlertID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateContactTracer(Connection con, ContactTracer c) throws SQLException {
		String query = "UPDATE CONTACT_TRACER SET FIRST_NAME=?, LAST_NAME=?, CENTER_ID=?, PASSWORD=?, SURNAME=?, REG_DATE=?, CONTACT_TRACER_ID=?, STATUS=? WHERE CONTACT_TRACER_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, c.getFirstName());
			pst.setString(2, c.getLastName());
			pst.setInt(3, c.getCenterID());
			pst.setString(4, c.getPassword());
			pst.setString(5, c.getSurname());
			pst.setTimestamp(6, c.getRegDate());
			pst.setInt(7, c.getContactTracerID());
			pst.setString(8, c.getStatus());
			pst.setInt(9, c.getContactTracerID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCounty(Connection con, County c) throws SQLException {
		String query = "UPDATE COUNTIES SET COUNTY_ID=?, COUNTY=? WHERE COUNTY_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, c.getCountyID());
			pst.setString(2, c.getCounty());
			pst.setInt(3, c.getCountyID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateMedicalCenter(Connection con, MedicalCenter m) throws SQLException {
		String query = "UPDATE MEDICAL_CENTER SET CENTER_ID=?, PHONE=?, COUNTY_ID=?, NAME=?, ABOUT=?, LOCATION=?, EMAIL=? WHERE CENTER_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, m.getCenterID());
			pst.setInt(2, m.getPhone());
			pst.setInt(3, m.getCountyID());
			pst.setString(4, m.getName());
			pst.setString(5, m.getAbout());
			pst.setString(6, m.getLocation());
			pst.setString(7, m.getEmail());
			pst.setInt(8, m.getCenterID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateNotification(Connection con, Notification n) throws SQLException {
		String query = "UPDATE NOTIFICATIONS SET DATE_OCCURED=?, COUNTY_ID=?, NOTIFICATION_ID=?, DETAILS=? WHERE NOTIFICATION_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setTimestamp(1, n.getDateOccured());
			pst.setInt(2, n.getCountyID());
			pst.setInt(3, n.getNotificationID());
			pst.setString(4, n.getDetails());
			pst.setInt(5, n.getNotificationID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updatePlace(Connection con, Place p) throws SQLException {
		String query = "UPDATE PLACES SET COUNTY_ID=?, PLACE_ID=?, PLACE=? WHERE PLACE_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, p.getCountyID());
			pst.setInt(2, p.getPlaceID());
			pst.setString(3, p.getPlace());
			pst.setInt(4, p.getPlaceID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTraceOperation(Connection con, TraceOperation t) throws SQLException {
		String query = "UPDATE TRACE_OPERATION SET SUBJECT=?, OPERATION_ID=?, CONTACT_TRACER_ID=?, ALERT_ID=?, UPDATES=?, STATUS=? WHERE OPERATION_ID=?";

		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, t.getSubject());
			pst.setInt(2, t.getOperationID());
			pst.setInt(3, t.getContactTracerID());
			pst.setInt(4, t.getAlertID());
			pst.setString(5, t.getUpdates());
			pst.setInt(6, t.getStatus());
			pst.setInt(7, t.getOperationID());
			pst.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
