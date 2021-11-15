package com.ruby.ui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruby.beans.Citizen;
import com.ruby.beans.ContactTracer;
import com.ruby.beans.TestOfficer;
import com.ruby.beans.UserLogin;
import com.ruby.db.DBConnection;
import com.ruby.db.DBFind;

@WebServlet(asyncSupported = true, urlPatterns = {"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt((String)request.getParameter("idNumber"));	
		String pass = request.getParameter("password");
		
		//UserLogin l = new UserLogin();
		//l.setIDNo(id);
		Connection con = DBConnection.createConnection();
		UserLogin l = null;
		try {
			l = DBFind.getUserLogin(con, id, pass);// from the database try and find a user that the credentials match
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("feedback", "AN ERROR OCCURED AND COULDN'T LOG YOU IN");
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(l != null) {
			if(l.getType().equalsIgnoreCase("c")) {		//User type is either of type C for Citizen / CT for contact-Tracer / TO for Test_officer
				Citizen c = null;
				try {
					c = DBFind.getCitizen(con, l.getIDNo());
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("feedback", "AN ERROR OCCURED AND COULDN'T LOG YOU IN");
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
					rd.forward(request, response);
					return;
				}
				
				request.getSession().setAttribute("citizenContext", c);
				response.sendRedirect(this.getServletContext().getContextPath() + "/citizen/profile");
			} else if(l.getType().equalsIgnoreCase("ct")) {
				ContactTracer ct = null;
				try {
					ct = DBFind.getContactTracer(con, id);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("feedback", "AN ERROR OCCURED AND COULDN'T LOG YOU IN");
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
					rd.forward(request, response);
					return;
				}
				
				request.getSession().setAttribute("ctContext", ct);
				response.sendRedirect(this.getServletContext().getContextPath() + "/ct/");
			}
			 else if(l.getType().equalsIgnoreCase("to")) {
					TestOfficer to = null;
					try {
						to = DBFind.getTestOfficer(con, id);
					} catch (SQLException e) {
						e.printStackTrace();
						request.setAttribute("feedback", "AN ERROR OCCURED AND COULDN'T LOG YOU IN");
						if(con != null) {
							try {
								con.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
						rd.forward(request, response);
						return;
					}
					
					request.getSession().setAttribute("toContext", to);
					response.sendRedirect(this.getServletContext().getContextPath() + "/to/home");
				}
		} else {	// login is null
			request.setAttribute("feedback", "SEEMS YOU ARE NOT REGISTERED OR WRONG CREDENTIALS");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/LOGIN.jsp");
			rd.forward(request, response);
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
