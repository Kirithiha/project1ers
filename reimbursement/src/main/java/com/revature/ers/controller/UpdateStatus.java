package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.service.implementation.ReimburseServiceImplementation;

/**
 * Servlet implementation class UpdateStatus
 */
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStatus() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String email = request.getParameter("id");
		String status="pending";
		
		if(action.equals("approve"))
			status = "approve";
		else if(action.equals("deny"))
			status = "deny";
		ReimburseServiceImplementation r_impl = new ReimburseServiceImplementation();
		int result = r_impl.update(status, email);
		if(result == 1) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Status updated Successfully ... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/verify.jsp';");
		    out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Error in updating Status');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/verify.jsp';");
		    out.println("</script>");
		}
	}

}
