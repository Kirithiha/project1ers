package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.dto.User;
import com.revature.ers.service.implementation.UserServiceImplementation;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateEmployee() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("emailid");
		String designation = request.getParameter("Designation");
		String usrname = request.getParameter("usr");
		String account = request.getParameter("act");
		String branch = request.getParameter("branch");
		String code = request.getParameter("code");
		String phn = request.getParameter("phn");
			User u = new User();
			u.setEmailid(email);
			u.setDesignation(designation);
			u.setAccountNumber(account);
			u.setBranchName(branch);
			u.setIfscCode(code);
			u.setUserName(usrname);
			u.setPhnNo(phn);
			UserServiceImplementation u_impl = new UserServiceImplementation();
			int result = u_impl.updateUser(u);
			if(result == 1) {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('User updated Successfully ... :)');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/employee/homepage.jsp';");
			    out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Error in adding User');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/employee/homepage.jsp';");
			    out.println("</script>");
			}
	}

}
