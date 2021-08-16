package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.dto.User;
import com.revature.ers.service.implementation.UserServiceImplementation;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	
	Logger log = Logger.getLogger("Signup.class");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Inside SIGNUP SERVLET");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("emailid");
		String passwd = request.getParameter("passwdSignup");
		String repasswd = request.getParameter("repeatPass");
		String designation = request.getParameter("Designation");
		String usrname = request.getParameter("usr");
		String account = request.getParameter("act");
		String branch = request.getParameter("branch");
		String code = request.getParameter("code");
		String phn = request.getParameter("phn");
		if(passwd.equals(repasswd)) {
			User u = new User();
			u.setEmailid(email);
			u.setPassword(passwd);
			u.setDesignation(designation);
			u.setAccountNumber(account);
			u.setBranchName(branch);
			u.setIfscCode(code);
			u.setUserName(usrname);
			u.setPhnNo(phn);
			UserServiceImplementation u_impl = new UserServiceImplementation();
			int result = u_impl.addUser(u);
			if(result == 1) {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('User added Successfully ... :)');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
			    out.println("</script>");
			}
			else if(result == 2 ) {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('User Already Found');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
			    out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Error in adding User');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
			    out.println("</script>");
			}
		} else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Retype your password correctly');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
		    out.println("</script>");
		}
	}

}
