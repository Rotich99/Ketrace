package com.ruby.ui;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

@WebServlet(asyncSupported = true, urlPatterns = {"/SW.js"})
public class SwJs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SwJs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Service worker triggered! @" + new Date(System.currentTimeMillis()));
		PrintWriter p = response.getWriter();
		String sw = this.getServletContext().getInitParameter("service-worker");
		String path = this.getServletContext().getRealPath("") + File.separator + sw;
		
		List<String> lines = FileUtils.readLines(new File(path), "UTF-8");
		//System.out.println("Our service worker\n" + lines);
		for(String s : lines) {
			p.println(s);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
