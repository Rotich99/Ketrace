package com.ruby.ui.testofficer;

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

import com.ruby.beans.Citizen;
import com.ruby.beans.County;
import com.ruby.beans.MedicalCenter;
import com.ruby.beans.TestOfficer;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/to/medicalcenter"})
public class TOMedicalCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TOMedicalCenter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TestOfficer to = (TestOfficer) session.getAttribute("toContext");
		int countyID = to.getCountyID();
		
		List<MedicalCenter> cList = null;
		Connection con = DBConnection.createConnection();
		try {
			cList = DBFind.getMedicalCenterList(con, countyID);
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
		
		request.setAttribute("medList", cList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/to/TO_CONTACT_MEDICAL_CENTER.jsp");
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
