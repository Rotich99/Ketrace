package com.ruby.db;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String URL = "jdbc:mysql://localhost:3306/ke_tracecovid?verifyServerCertificate=false&useSSL=false&requireSSL=false";
	private static String USER = "root";
	private static String PASS = "Student@2021!";
	
	public static Connection createConnection() {
		Connection co = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			co = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(co != null) {
			System.out.println("database connection made " + new Date(System.currentTimeMillis()));
		}
		return co;
	}
}