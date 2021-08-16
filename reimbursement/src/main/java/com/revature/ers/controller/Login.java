package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.ers.dto.User;
import com.revature.ers.service.implementation.UserServiceImplementation;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	Logger log = Logger.getLogger("Login.class");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	// TO CHECK FOR VALIDATION.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("LOGIN SERVLET");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("username");
		String passwd = request.getParameter("passwordLogin");
		UserServiceImplementation u_impl = new UserServiceImplementation();
		int result = u_impl.validation(email,passwd);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("username", email);
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Loggedin Successfully ... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/employee/homepage.jsp';");
		    out.println("</script>");
		} else if(result == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("username", email);
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Loggedin Successfully Admin... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/homepage.jsp';");
		    out.println("</script>");
		}
		else if(result == 2 ) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Incorrect Password');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
		    out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Incorrect User name');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
		    out.println("</script>");
		}
	}

}
