package com.ruby.ui.testofficer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruby.a.util.Uniqa;
import com.ruby.beans.Chat;
import com.ruby.beans.Citizen;
import com.ruby.beans.MedicalCenter;
import com.ruby.beans.TestOfficer;
import com.ruby.db.DBConnection;
import com.ruby.db.DBCreate;
import com.ruby.db.DBFind;
import com.ruby.db.DBUpdate;

@WebServlet(asyncSupported = true, urlPatterns = {"/to/chat/center"})
public class TOChatCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TOChatCenter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TestOfficer to = (TestOfficer) session.getAttribute("toContext");
		int centerID = Integer.parseInt(request.getParameter("center"));
		MedicalCenter m = null;
		List<Chat> chatList = null;
		Connection con = DBConnection.createConnection();
		try {
			m = DBFind.getMedicalCenter(con, centerID);
			chatList = DBFind.getChatList(con, to.getNationalID(), centerID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("contextChat", m);
		request.setAttribute("chatList", chatList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/to/TO_CHAT.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intent = request.getParameter("intent");
		boolean hasError = false;
		String error = "SUCCESS";
		Connection con = DBConnection.createConnection();
		switch(intent) {
		case "postMessage":
			Chat c = new Chat();
			c.setRecepientID(Integer.parseInt(request.getParameter("recipientID")));
			c.setSenderID(Integer.parseInt(request.getParameter("senderID")));
			c.setChatID(Uniqa.generateMessageID(con));//Integer.parseInt(request.getParameter("chatID")));
			c.setSubject("");
			c.setMessage(request.getParameter("message"));
			c.setDateSent(new Timestamp(System.currentTimeMillis()));
			c.setStatus(0);
			
			response.setContentType("text/plain");
			try {
				 DBCreate.createChat(con, c);
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
		}
		
	}

}
