package com.ruby.ui.testofficer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruby.beans.Chat;
import com.ruby.beans.Citizen;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/to/chat"})
public class TOChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TOChat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/to/TO_CHAT.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		
		System.out.println("Intention: " + intent);
		
		switch(intent) {
		case "postMessage":
			Chat c = new Chat();
			c.setRecepientID(Integer.parseInt(request.getParameter("recipientID")));
			c.setSenderID(Integer.parseInt(request.getParameter("senderID")));
			c.setChatID(Integer.parseInt(request.getParameter("chatID")));
			c.setSubject("");
			c.setMessage(request.getParameter("message"));
			c.setDateSent(new Timestamp(System.currentTimeMillis()));
			c.setStatus(0);
			
			response.setContentType("text/plain");
			try {
				DBUpdate.updateChat(con, c);
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
