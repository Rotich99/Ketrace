package com.ruby.ui.contacttracer;

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
import com.ruby.beans.ContactTracer;
import com.ruby.beans.County;
import com.ruby.beans.TestOfficer;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/ct/alerts"})
public class ReceiveAlerts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveAlerts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//ContactTracer ct = (ContactTracer) session.getAttribute("ctContext");
		//int countyID = ct.getContactTracerID()
		
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
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/ct/CT_RECEIVE_ALERTS.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		
		System.out.println("Intention: " + intent);
		
		/**
		 * NOT OKAY!!!!!!!!!
		 */
		
		Citizen c = new Citizen();
		c.setFirstName(request.getParameter("firstName"));
		c.setLastName(request.getParameter("lastName"));
		c.setPassword(request.getParameter("password"));
		c.setPhone(Integer.parseInt(request.getParameter("phone")));
		c.setIDNo(Integer.parseInt(request.getParameter("IDNo")));
		c.setEmail(request.getParameter("email"));
		
		response.setContentType("text/plain");
		try {
			 DBUpdate.updateCitizen(con, c);
			 } catch(SQLException e) {
			hasError = true;
			error = "FAIL";
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				} 
			}catch(SQLException ex) {
					ex.printStackTrace();
			}
			request.setAttribute("error", error);

			response.getWriter().write(error);
		}
		
	}

}
