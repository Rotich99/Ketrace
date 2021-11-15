package com.ruby.a.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Uniqa {
	public static int generateAlertID(Connection con) {
		String raw = "1234567890";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		while(sb.length() < 9) {
			int index = (int) (r.nextFloat() * raw.length());
			sb.append(raw.charAt(index));
		}
		
		int genNO = Integer.parseInt(sb.toString());
		boolean isUnique = true;
		
		try {
			isUnique = isUniqueAlertID(con, genNO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isUnique == false) {
			generateAlertID(con);
		}
		return genNO;
	}
	
	public static boolean isUniqueAlertID(Connection con, int alertID) throws SQLException {
		String sql = "SELECT ALERT_ID FROM ALERT"
				+ "WHERE ALERT_ID=?";
		boolean unique = true;
		try (PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, alertID);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				unique = false;
				return unique;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return unique;
	}
	
	public static int generateCenterID(Connection con) {
		String raw = "1234567890";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		while(sb.length() < 9) {
			int index = (int) (r.nextFloat() * raw.length());
			sb.append(raw.charAt(index));
		}
		
		int genNO = Integer.parseInt(sb.toString());
		boolean isUnique = true;
		
		try {
			isUnique = isUniqueCenterID(con, genNO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isUnique == false) {
			generateAlertID(con);
		}
		return genNO;
	}
	
	public static boolean isUniqueCenterID(Connection con, int id) throws SQLException {
		String sql = "SELECT CENTER_ID FROM MEDICAL_CENTER"
				+  "WHERE CENTER_ID=?";
		boolean unique = true;
		try (PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				unique = false;
				return unique;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return unique;
	}
	
	public static int generateMessageID(Connection con) {
		String raw = "1234567890";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		while(sb.length() < 9) {
			int index = (int) (r.nextFloat() * raw.length());
			sb.append(raw.charAt(index));
		}
		
		int genNO = Integer.parseInt(sb.toString());
		boolean isUnique = true;
		
		try {
			isUnique = isUniqueMessageID(con, genNO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isUnique == false) {
			generateAlertID(con);
		}
		return genNO;
	}
	
	public static boolean isUniqueMessageID(Connection con, int alertID) throws SQLException {
		String sql = "SELECT CHAT_ID FROM CHATS"
				+ "WHERE CHAT_ID=?";
		boolean unique = true;
		try (PreparedStatement pst = con.prepareStatement(sql);){
			pst.setInt(1, alertID);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				unique = false;
				return unique;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return unique;
	}
}
