package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.service.implementation.UserServiceImplementation;

/**
 * Servlet implementation class ForgetPassword
 */
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgetPassword() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String repasswd = request.getParameter("repass");
		if(passwd.equals(repasswd)) {
			UserServiceImplementation u_impl = new UserServiceImplementation();
			int result = u_impl.updateLogin(email, passwd);
			if(result == 1) {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Password updated Successfully ... :)');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
			    out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Error in updating password');");
			    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
			    out.println("</script>");
			} 
		}  else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Retype your password correctly');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/forgetpassword.html';");
		    out.println("</script>");
		}
	}

}
