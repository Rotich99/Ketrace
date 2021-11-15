package com.ruby.ui;

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

import com.ruby.beans.Citizen;
import com.ruby.beans.ContactTracer;
import com.ruby.beans.TestOfficer;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/register"})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/pub/REGISTER.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		
		System.out.println("Intention: " + intent);
		switch(intent) {
		case "add-new-citizen":
			System.out.println("Adding a new Citizen");
			Citizen c = new Citizen();
			c.setFirstName(request.getParameter("firstName"));
			c.setLastName(request.getParameter("lastName"));
			c.setPassword(request.getParameter("password"));
			c.setPhone(Integer.parseInt(request.getParameter("phone")));
			c.setIDNo(Integer.parseInt(request.getParameter("IDNo")));
			c.setEmail(request.getParameter("email"));
						
			response.setContentType("text/plain");
			try {
				 DBCreate.createCitizen(con, c);
			} catch(SQLException e) {
				hasError = true;
				error = "FAIL";
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {  //if there is no connection then it wont execute
						con.close();
					} 
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
				request.setAttribute("error", error);
				
				request.getSession().setAttribute("citizenContext", c);

				response.getWriter().write(error);
			}
			
			break;
		
		case "add-new-testOfficer":
			System.out.println("Adding a new TestOfficer");
			TestOfficer t = new TestOfficer();
			t.setFirstName(request.getParameter("firstName"));
			t.setLastName(request.getParameter("lastName"));
			t.setPassword(request.getParameter("password"));
			t.setNationalID(Integer.parseInt(request.getParameter("IDNo")));
			//t.setCountyID(Integer.parseInt(request.getParameter("countyID")));
			t.setRegDate(new Date(System.currentTimeMillis()));
			t.setLocation(""); //request.getParameter("location"));
			t.setCompany("");	//request.getParameter("company"));
			
			response.setContentType("text/plain");
			try {
				 DBCreate.createTestOfficer(con, t);
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
				request.getSession().setAttribute("toContext",t);
				response.getWriter().write(error);
			}
			break;
		
		case "add-new-contactTracer":
			System.out.println("Adding a new contactTracer");
			ContactTracer ct = new ContactTracer();
			ct.setFirstName(request.getParameter("firstName"));
			ct.setLastName(request.getParameter("lastName"));
			///ct.setCenterID(Integer.parseInt(request.getParameter("centerID")));
			ct.setPassword(request.getParameter("password"));
			ct.setSurname(request.getParameter("surname"));
			ct.setRegDate(new Timestamp(System.currentTimeMillis()));
			ct.setContactTracerID(Integer.parseInt(request.getParameter("IDNo")));
			//ct.setStatus(0);//request.getParameter("status"));
			
			response.setContentType("text/plain");
			try {
				 DBCreate.createContactTracer(con, ct);
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
				request.getSession().setAttribute("ctContext", ct);
				response.getWriter().write(error);
			}
			break;
			
		/*
		 * ADD a TestOfficer
		 */
				
		/*
		 * UPDATE Citizen
		*/
		case "update-citizen":
			c = new Citizen();
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
			
			break;
		/*
		 * UPDATE Citizen
		*/
		case "remove-citizen":
			int IDNo = Integer.parseInt(request.getParameter("IDNo"));;
			
			response.setContentType("text/plain");
			/*
			try {
				 //DBRemove.removeCitizen(con, IDNo);
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
			*/
			break;
		} // END SWITCH
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
