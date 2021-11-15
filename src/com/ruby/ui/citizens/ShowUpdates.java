package com.ruby.ui.citizens;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruby.beans.Alert;
import com.ruby.beans.Citizen;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/citizen/updates"})
public class ShowUpdates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowUpdates() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/citizen/CITIZEN_BROWSE UPDATES.jsp");
		rd.forward(request, response);
	
	List<Alert> aList = null;
	Connection con = DBConnection.createConnection();
	try {
		aList = DBFind.getAlertList(con);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		/*
		for(Alert a : aList) {
			System.out.println("Date Recorded" + a.getDateRecorded().toLocaleString());
		}
		*/
		request.setAttribute("alertList", aList);
		RequestDispatcher r = this.getServletContext().getRequestDispatcher("/WEB-INF/citizen/CITIZEN_BROWSE UPDATES.jsp");
		r.forward(request, response);
	}
}

	