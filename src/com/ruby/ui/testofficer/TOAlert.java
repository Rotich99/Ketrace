package com.ruby.ui.testofficer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruby.a.util.Uniqa;
import com.ruby.beans.Alert;
import com.ruby.beans.Citizen;
import com.ruby.beans.County;
import com.ruby.beans.Notification;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/to/alert"})
public class TOAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TOAlert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<County> cList = null;
		Connection con = DBConnection.createConnection();
		try {
			cList = DBFind.getCountyList(con);
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
		
		request.setAttribute("countyList", cList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/to/TO_RECORD_ALERT.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		switch(intent) {
		case "add-new-alert":
			Alert a = new Alert();
			a.setDateRecorded(new Timestamp(System.currentTimeMillis()));
			a.setTestOfficerID(Integer.parseInt(request.getParameter("testOfficerID")));
			a.setLocationID(Integer.parseInt(request.getParameter("countyID").trim()));
			a.setTemperature(Float.parseFloat(request.getParameter("temperature")));
			a.setDescriptionAge(Integer.parseInt(request.getParameter("descriptionAge")));
			a.setAlertID(Uniqa.generateAlertID(con));  //Integer.parseInt(request.getParameter("alertID")));
			a.setId(Integer.parseInt(request.getParameter("suspectID")));
			a.setPreciseLocation(request.getParameter("preciseLocation"));
			
			response.setContentType("text/plain");
			
			/*
			 * CREATE NOTIFICATION
			 */
			Notification n = new Notification();
			n.setNotificationID(Uniqa.generateAlertID(con));
			n.setCountyID(a.getLocationID());
			n.setDateOccured(new Timestamp(System.currentTimeMillis()));
			n.setDetails("1 case reported around " + a.getPreciseLocation() + "\n.The person is alleged to be of age " + a.getDescriptionAge() + "\n.Be careful and get tested today!");
			
			try {
				 DBCreate.createAlert(con, a);
				 DBCreate.createNotification(con, n);
			} catch(SQLException e) {
				hasError = true;
				error = "FAILED";
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {
						con.close();
					} 
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				//request.setAttribute("error", error);
				response.getWriter().write(error);
			}
		break;

		/*
		 * UPDATE Alert
		 * DOING AWAY BECAUSE
		 * 	The TestOfficer either records a case or removes the case.
		*/
		/*
		case "update-alert":
			Alert a = new Alert();
			//a.setDateRecorded(request.getParameter("dateRecorded"));
			a.setTestOfficerID(Integer.parseInt(request.getParameter("testOfficerID")));
			a.setLocationID(Integer.parseInt(request.getParameter("locationID")));
			//a.setTemperature(request.getParameter("temperature"));
			a.setDescriptionAge(Integer.parseInt(request.getParameter("descriptionAge")));
			a.setAlertID(Integer.parseInt(request.getParameter("alertID")));
			a.setId(Integer.parseInt(request.getParameter("id")));
			a.setPreciseLocation(request.getParameter("preciseLocation"));
			
			response.setContentType("text/plain");
			try {
				 DBCreate.updateAlert(con, a);
			} catch(SQLException e) {
				hasError = true;
				error = "FAIL";
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {
						con.close();
					} catch(SQLException ex) {
						ex.printStackTrace();
					}
				}
				request.setAttribute("error", error);

				response.getWriter().write(error);
			}
			
			*/
		}		
	}

}
