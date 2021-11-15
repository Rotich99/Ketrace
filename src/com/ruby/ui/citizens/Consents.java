package com.ruby.ui.citizens;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruby.a.util.Uniqa;
import com.ruby.beans.Citizen;
import com.ruby.beans.Consent;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/citizen/consents"})
public class Consents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Consents() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/citizen/MAKE_CONSENT.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		switch(intent) {
		case "add-new-consent":
			Consent c = new Consent();
			c.setDateRecorded(new Timestamp(System.currentTimeMillis()));
			c.setLocationID(Integer.parseInt(request.getParameter("locationID")));
			c.setDescription(request.getParameter("description"));
			c.setAlertID(Uniqa.generateAlertID(con));
			c.setID(Integer.parseInt(request.getParameter("suspectID")));
			c.setPreciseLocation(request.getParameter("preciseLocation"));
			
			response.setContentType("text/plain");
			try {
				 DBCreate.createConsent(con, c);
			} catch(SQLException e) {
				hasError = true;
				error = "FAIL";
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {
						con.close();
					} 
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				
				request.setAttribute("error", error);

				response.getWriter().write(error);
			}
			break;

		/*
		 * UPDATE Consent
		*/
		case "update-consent":
			c = new Consent();
			//c.setDateRecorded(request.getParameter("dateRecorded"));
			c.setLocationID(Integer.parseInt(request.getParameter("locationID")));
			c.setDescription(request.getParameter("description"));
			c.setAlertID(Integer.parseInt(request.getParameter("alertID")));
			c.setID(Integer.parseInt(request.getParameter("id")));
			c.setPreciseLocation(request.getParameter("preciseLocation"));
			
			response.setContentType("text/plain");
			try {
				 DBUpdate.updateConsent(con, c);
			} catch(SQLException e) {
				hasError = true;
				error = "FAIL";
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {
						con.close();
					} 
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				request.setAttribute("error", error);

				response.getWriter().write(error);
			}
		}
	}

}
