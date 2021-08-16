package com.revature.ers.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.dto.Reimburse;
import com.revature.ers.service.implementation.ReimburseServiceImplementation;

/**
 * Servlet implementation class ReimburseRequest
 */
public class ReimburseRequest extends HttpServlet {
	
	Logger log = Logger.getLogger("ReimburseRequest.class");
	private static final long serialVersionUID = 1L;
       
    public ReimburseRequest() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Inside REIMBURSEREQUEST SERVLET");
		PrintWriter out = response.getWriter();
		Reimburse re = new Reimburse();
		String emailid = request.getParameter("email");
		re.setEmailid(emailid);
		re.setReason(request.getParameter("reason"));
		re.setType(request.getParameter("type"));
		re.setAmount(request.getParameter("amount"));
		re.setDate(request.getParameter("date"));
		System.out.println(request.getParameter("date"));
		ReimburseServiceImplementation r_impl = new ReimburseServiceImplementation();
		int result = r_impl.addReimburse(re);
		if(result == 1) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Reimburse Requested Successfully ... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/employee/reimbursement.jsp';");
		    out.println("</script>");
		} else if(result == 2 ) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Error in requesting reimburse');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/employee/homepage.jsp';");
		    out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Incorrect User name');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/firstpage.jsp';");
		    out.println("</script>");
		}
	}

}
