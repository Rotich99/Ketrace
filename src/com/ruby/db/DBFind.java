package com.ruby.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruby.beans.*;

public class DBFind {
	public static Citizen getCitizen(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM CITIZENS WHERE ID_NO = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Citizen c = new Citizen();
				c.setFirstName(rs.getString("FIRST_NAME"));
				c.setLastName(rs.getString("LAST_NAME"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setPhone(rs.getInt("PHONE"));
				c.setIDNo(rs.getInt("ID_NO"));
				c.setEmail(rs.getString("EMAIL"));
				return c;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Citizen> getCitizenList(Connection con) throws SQLException {
		String query = "SELECT * FROM CITIZENS";
		List<Citizen> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Citizen c = new Citizen();
				c.setFirstName(rs.getString("FIRST_NAME"));
				c.setLastName(rs.getString("LAST_NAME"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setPhone(rs.getInt("PHONE"));
				c.setIDNo(rs.getInt("ID_NO"));
				c.setEmail(rs.getString("EMAIL"));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	public static UserLogin getUserLogin(Connection con, int id, String password) throws SQLException {
		String query = "SELECT * FROM USER_LOGINS WHERE USER_ID = ? AND PASSWORD=?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, id);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				UserLogin l = new UserLogin();
				
				l.setIDNo(rs.getInt("USER_ID"));
				l.setPassword(rs.getString("PASSWORD"));
				l.setType(rs.getString("USERTYPE"));
				
				System.out.println("USER FOUND " + l.getIDNo() + " " + l.getPassword() + " " + l.getType());
				
				return l;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ TestOfficer**********************************************/
	public static TestOfficer getTestOfficer(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM TEST_OFFICER WHERE NATIONAL_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				TestOfficer t = new TestOfficer();
				t.setFirstName(rs.getString("FIRST_NAME"));
				t.setLastName(rs.getString("LAST_NAME"));
				t.setPassword(rs.getString("PASSWORD"));
				t.setNationalID(rs.getInt("NATIONAL_ID"));
				t.setCountyID(rs.getInt("COUNTY_ID"));
				t.setRegDate(rs.getDate("REG_DATE"));
				t.setLocation(rs.getString("LOCATION"));
				t.setCompany(rs.getString("COMPANY"));
				return t;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF TestOfficers**********************************************/

	public static List<TestOfficer> getTestOfficerList(Connection con) throws SQLException {
		String query = "SELECT * FROM TEST_OFFICER";
		List<TestOfficer> tList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				TestOfficer t = new TestOfficer();
				t.setFirstName(rs.getString("FIRST_NAME"));
				t.setLastName(rs.getString("LAST_NAME"));
				t.setPassword(rs.getString("PASSWORD"));
				t.setNationalID(rs.getInt("NATIONAL_ID"));
				t.setCountyID(rs.getInt("COUNTY_ID"));
				t.setRegDate(rs.getDate("REG_DATE"));
				t.setLocation(rs.getString("LOCATION"));
				t.setCompany(rs.getString("COMPANY"));

				tList.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ Alert**********************************************/
	public static Alert getAlert(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM ALERT WHERE ALERT_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Alert a = new Alert();
				a.setDateRecorded(rs.getTimestamp("DATE_RECORDED"));
				a.setTestOfficerID(rs.getInt("TEST_OFFICER_ID"));
				a.setLocationID(rs.getInt("LOCATION_ID"));
				a.setTemperature(rs.getFloat("TEMPERATURE"));
				a.setDescriptionAge(rs.getInt("DESCRIPTION_AGE"));
				a.setAlertID(rs.getInt("ALERT_ID"));
				a.setId(rs.getInt("ID"));  //suspect ID
				a.setPreciseLocation(rs.getString("PRECISE_LOCATION"));
				return a;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Alerts**********************************************/
	public static List<Alert> getAlertList(Connection con) throws SQLException {
		String query = "SELECT * FROM ALERT";
		List<Alert> aList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Alert a = new Alert();
				a.setDateRecorded(rs.getTimestamp("DATE_RECORDED"));
				a.setTestOfficerID(rs.getInt("TEST_OFFICER_ID"));
				a.setLocationID(rs.getInt("LOCATION_ID"));
				a.setTemperature(rs.getFloat("TEMPERATURE"));
				a.setDescriptionAge(rs.getInt("DESCRIPTION_AGE"));
				a.setAlertID(rs.getInt("ALERT_ID"));
				a.setId(rs.getInt("ID"));
				a.setPreciseLocation(rs.getString("PRECISE_LOCATION"));
				
				//Evolution X
				a.setCounty(getCounty(con, rs.getInt("LOCATION_ID")).getCounty());
				a.setReporter(getTestOfficer(con, a.getTestOfficerID()));
				aList.add(a);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ AssociateTraceContact**********************************************/
	public static AssociateTraceContact getAssociateTraceContact(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM ASSOCIATE_TRACE_CONTACT WHERE CONTACT_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				AssociateTraceContact a = new AssociateTraceContact();
				a.setContactID(rs.getInt("CONTACT_ID"));
				a.setPhone(rs.getInt("PHONE"));
				a.setCountyID(rs.getInt("COUNTY_ID"));
				a.setFullName(rs.getString("FULL_NAME"));
				a.setLocation(rs.getString("LOCATION"));
				a.setComment(rs.getString("COMMENT"));
				a.setIdNo(rs.getInt("ID_NO"));
				a.setStatus(rs.getInt("STATUS"));
				return a;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF AssociateTraceContacts**********************************************/
	public static List<AssociateTraceContact> getAssociateTraceContactList(Connection con) throws SQLException {
		String query = "SELECT * FROM ASSOCIATE_TRACE_CONTACT";
		List<AssociateTraceContact> aList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				AssociateTraceContact a = new AssociateTraceContact();
				a.setContactID(rs.getInt("CONTACT_ID"));
				a.setPhone(rs.getInt("PHONE"));
				a.setCountyID(rs.getInt("COUNTY_ID"));
				a.setFullName(rs.getString("FULL_NAME"));
				a.setLocation(rs.getString("LOCATION"));
				a.setComment(rs.getString("COMMENT"));
				a.setIdNo(rs.getInt("ID_NO"));
				a.setStatus(rs.getInt("STATUS"));

				aList.add(a);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ Chat**********************************************/
	public static Chat getChat(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM CHATS WHERE CHAT_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Chat c = new Chat();
				c.setRecepientID(rs.getInt("RECEPIENT_ID"));
				c.setSenderID(rs.getInt("SENDER_ID"));
				c.setChatID(rs.getInt("CHAT_ID"));
				c.setSubject(rs.getString("SUBJECT"));
				c.setMessage(rs.getString("MESSAGE"));
				c.setDateSent(rs.getTimestamp("DATE_SENT"));
				c.setStatus(rs.getInt("STATUS"));
				return c;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Chats**********************************************/
	public static List<Chat> getChatList(Connection con) throws SQLException {
		String query = "SELECT * FROM CHATS";
		List<Chat> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Chat c = new Chat();
				c.setRecepientID(rs.getInt("RECEPIENT_ID"));
				c.setSenderID(rs.getInt("SENDER_ID"));
				c.setChatID(rs.getInt("CHAT_ID"));
				c.setSubject(rs.getString("SUBJECT"));
				c.setMessage(rs.getString("MESSAGE"));
				c.setDateSent(rs.getTimestamp("DATE_SENT"));
				c.setStatus(rs.getInt("STATUS"));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	public static List<Chat> getChatList(Connection con, int senderID, int recipientID) throws SQLException {
		String query = "SELECT * FROM CHATS WHERE SENDER_ID=" + senderID + " AND RECEPIENT_ID=" + recipientID + " ORDER BY DATE_SENT ASC";
		List<Chat> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Chat c = new Chat();
				c.setRecepientID(rs.getInt("RECEPIENT_ID"));
				c.setSenderID(rs.getInt("SENDER_ID"));
				c.setChatID(rs.getInt("CHAT_ID"));
				c.setSubject(rs.getString("SUBJECT"));
				c.setMessage(rs.getString("MESSAGE"));
				c.setDateSent(rs.getTimestamp("DATE_SENT"));
				c.setStatus(rs.getInt("STATUS"));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ Consent**********************************************/
	public static Consent getConsent(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM CONSENT WHERE ALERT_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Consent c = new Consent();
				c.setDateRecorded(rs.getTimestamp("DATE_RECORDED"));
				c.setLocationID(rs.getInt("LOCATION_ID"));
				c.setDescription(rs.getString("DESCRIPTION"));
				c.setAlertID(rs.getInt("ALERT_ID"));
				c.setID(rs.getInt("ID"));
				c.setPreciseLocation(rs.getString("PRECISE_LOCATION"));
				return c;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Consents**********************************************/
	public static List<Consent> getConsentList(Connection con) throws SQLException {
		String query = "SELECT * FROM CONSENT ORDER BY DATE_RECORDED DESC";
		List<Consent> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Consent c = new Consent();
				c.setDateRecorded(rs.getTimestamp("DATE_RECORDED"));
				c.setLocationID(rs.getInt("LOCATION_ID"));
				c.setDescription(rs.getString("DESCRIPTION"));
				c.setAlertID(rs.getInt("ALERT_ID"));
				c.setID(rs.getInt("ID"));
				c.setPreciseLocation(rs.getString("PRECISE_LOCATION"));
				
				c.setCitizen(getCitizen(con, rs.getInt("ID")));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ ContactTracer**********************************************/
	public static ContactTracer getContactTracer(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM CONTACT_TRACER WHERE CONTACT_TRACER_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				ContactTracer c = new ContactTracer();
				c.setFirstName(rs.getString("FIRST_NAME"));
				c.setLastName(rs.getString("LAST_NAME"));
				c.setCenterID(rs.getInt("CENTER_ID"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setSurname(rs.getString("SURNAME"));
				c.setRegDate(rs.getTimestamp("REG_DATE"));
				c.setContactTracerID(rs.getInt("CONTACT_TRACER_ID"));
				c.setStatus(rs.getString("STATUS"));
				return c;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF ContactTracers**********************************************/
	public static List<ContactTracer> getContactTracerList(Connection con) throws SQLException {
		String query = "SELECT * FROM CONTACT_TRACER";
		List<ContactTracer> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				ContactTracer c = new ContactTracer();
				c.setFirstName(rs.getString("FIRST_NAME"));
				c.setLastName(rs.getString("LAST_NAME"));
				c.setCenterID(rs.getInt("CENTER_ID"));
				c.setPassword(rs.getString("PASSWORD"));
				c.setSurname(rs.getString("SURNAME"));
				c.setRegDate(rs.getTimestamp("REG_DATE"));
				c.setContactTracerID(rs.getInt("CONTACT_TRACER_ID"));
				c.setStatus(rs.getString("STATUS"));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ County**********************************************/
	public static County getCounty(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM COUNTIES WHERE COUNTY_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				County c = new County();
				c.setCountyID(rs.getInt("COUNTY_ID"));
				c.setCounty(rs.getString("COUNTY"));
				return c;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Countys**********************************************/
	public static List<County> getCountyList(Connection con) throws SQLException {
		String query = "SELECT * FROM COUNTIES ORDER BY COUNTY ASC";
		List<County> cList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				County c = new County();
				c.setCountyID(rs.getInt("COUNTY_ID"));
				c.setCounty(rs.getString("COUNTY"));

				cList.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ MedicalCenter**********************************************/
	public static MedicalCenter getMedicalCenter(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM MEDICAL_CENTER WHERE CENTER_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				MedicalCenter m = new MedicalCenter();
				m.setCenterID(rs.getInt("CENTER_ID"));
				m.setPhone(rs.getInt("PHONE"));
				m.setCountyID(rs.getInt("COUNTY_ID"));
				m.setName(rs.getString("NAME"));
				m.setAbout(rs.getString("ABOUT"));
				m.setLocation(rs.getString("LOCATION"));
				m.setEmail(rs.getString("EMAIL"));
				return m;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF MedicalCenters**********************************************/
	public static List<MedicalCenter> getMedicalCenterList(Connection con) throws SQLException {
		String query = "SELECT * FROM MEDICAL_CENTER";
		List<MedicalCenter> mList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				MedicalCenter m = new MedicalCenter();
				m.setCenterID(rs.getInt("CENTER_ID"));
				m.setPhone(rs.getInt("PHONE"));
				m.setCountyID(rs.getInt("COUNTY_ID"));
				m.setName(rs.getString("NAME"));
				m.setAbout(rs.getString("ABOUT"));
				m.setLocation(rs.getString("LOCATION"));
				m.setEmail(rs.getString("EMAIL"));

				mList.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	public static List<MedicalCenter> getMedicalCenterList(Connection con, int countyID) throws SQLException {
		String query = "SELECT * FROM MEDICAL_CENTER WHERE COUNTY_ID=" + countyID;
		List<MedicalCenter> mList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				MedicalCenter m = new MedicalCenter();
				m.setCenterID(rs.getInt("CENTER_ID"));
				m.setPhone(rs.getInt("PHONE"));
				m.setCountyID(rs.getInt("COUNTY_ID"));
				m.setName(rs.getString("NAME"));
				m.setAbout(rs.getString("ABOUT"));
				m.setLocation(rs.getString("LOCATION"));
				m.setEmail(rs.getString("EMAIL"));

				mList.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	/****************************DATABASE CRUD OPERATIONS: READ Notification**********************************************/
	public static Notification getNotification(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM NOTIFICATIONS WHERE NOTIFICATION_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Notification n = new Notification();
				n.setDateOccured(rs.getTimestamp("DATE_OCCURED"));
				n.setCountyID(rs.getInt("COUNTY_ID"));
				n.setNotificationID(rs.getInt("NOTIFICATION_ID"));
				n.setDetails(rs.getString("DETAILS"));
				return n;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Notifications**********************************************/
	public static List<Notification> getNotificationList(Connection con) throws SQLException {
		String query = "SELECT * FROM NOTIFICATIONS ORDER BY DATE_OCCURED DESC";
		List<Notification> nList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Notification n = new Notification();
				n.setDateOccured(rs.getTimestamp("DATE_OCCURED"));
				n.setCountyID(rs.getInt("COUNTY_ID"));
				n.setNotificationID(rs.getInt("NOTIFICATION_ID"));
				n.setDetails(rs.getString("DETAILS"));
				n.setCounty(getCounty(con, rs.getInt("COUNTY_ID")));
				nList.add(n);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return nList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ Place**********************************************/
	public static Place getPlace(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM PLACES WHERE PLACE_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Place p = new Place();
				p.setCountyID(rs.getInt("COUNTY_ID"));
				p.setPlaceID(rs.getInt("PLACE_ID"));
				p.setPlace(rs.getString("PLACE"));
				return p;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF Places**********************************************/
	public static List<Place> getPlaceList(Connection con) throws SQLException {
		String query = "SELECT * FROM PLACES";
		List<Place> pList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				Place p = new Place();
				p.setCountyID(rs.getInt("COUNTY_ID"));
				p.setPlaceID(rs.getInt("PLACE_ID"));
				p.setPlace(rs.getString("PLACE"));

				pList.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	/****************************DATABASE CRUD OPERATIONS: READ TraceOperation**********************************************/
	public static TraceOperation getTraceOperation(Connection con, int i) throws SQLException {
		String query = "SELECT * FROM TRACE_OPERATION WHERE OPERATION_ID = ?";
		try (PreparedStatement pst = con.prepareStatement(query);) {
			pst.setInt(1, i);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				TraceOperation t = new TraceOperation();
				t.setSubject(rs.getString("SUBJECT"));
				t.setOperationID(rs.getInt("OPERATION_ID"));
				t.setContactTracerID(rs.getInt("CONTACT_TRACER_ID"));
				t.setAlertID(rs.getInt("ALERT_ID"));
				t.setUpdates(rs.getString("UPDATES"));
				t.setStatus(rs.getInt("STATUS"));
				return t;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/****************************DATABASE CRUD OPERATIONS: READ LIST OF TraceOperations**********************************************/
	public static List<TraceOperation> getTraceOperationList(Connection con) throws SQLException {
		String query = "SELECT * FROM TRACE_OPERATION";
		List<TraceOperation> tList = new ArrayList<>();

		try (PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();) {
			while(rs.next()) {
				TraceOperation t = new TraceOperation();
				t.setSubject(rs.getString("SUBJECT"));
				t.setOperationID(rs.getInt("OPERATION_ID"));
				t.setContactTracerID(rs.getInt("CONTACT_TRACER_ID"));
				t.setAlertID(rs.getInt("ALERT_ID"));
				t.setUpdates(rs.getString("UPDATES"));
				t.setStatus(rs.getInt("STATUS"));

				tList.add(t);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tList;
	}


}
