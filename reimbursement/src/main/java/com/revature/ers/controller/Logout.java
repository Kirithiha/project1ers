package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Logout() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.invalidate();
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('Logged out Successfully ... :)');");
	    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
	    out.println("</script>");
	}

}
