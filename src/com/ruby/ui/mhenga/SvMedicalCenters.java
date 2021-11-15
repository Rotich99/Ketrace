package com.ruby.ui.mhenga;

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

import com.ruby.a.util.Uniqa;
import com.ruby.beans.Citizen;
import com.ruby.beans.County;
import com.ruby.beans.MedicalCenter;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/mhenga/medical-centers"})
public class SvMedicalCenters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvMedicalCenters() {
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
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/mhenga/MEDICAL_CENTER_ADD.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		switch(intent) {
		case "medicalcenterRegister":
			MedicalCenter m = new MedicalCenter();
			m.setCenterID(Uniqa.generateCenterID(con)); //request.getParameter("centerID")));
			m.setPhone(Integer.parseInt(request.getParameter("phone")));
			m.setCountyID(Integer.parseInt(request.getParameter("countyID")));
			m.setName(request.getParameter("name"));
			m.setAbout(request.getParameter("about"));
			m.setLocation(request.getParameter("location"));
			m.setEmail(request.getParameter("email"));
			
			response.setContentType("text/plain");
			try {
				 DBCreate.createMedicalCenter(con, m);
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
		 * UPDATE MedicalCenter
		*/
		case "update-medicalcenter":
			m = new MedicalCenter();
			m.setCenterID(Integer.parseInt(request.getParameter("centerID")));
			m.setPhone(Integer.parseInt(request.getParameter("phone")));
			m.setCountyID(Integer.parseInt(request.getParameter("countyID")));
			m.setName(request.getParameter("name"));
			m.setAbout(request.getParameter("about"));
			m.setLocation(request.getParameter("location"));
			m.setEmail(request.getParameter("email"));
			
			response.setContentType("text/plain");
			try {
				 DBUpdate.updateMedicalCenter(con, m);
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
		}
	}

}
