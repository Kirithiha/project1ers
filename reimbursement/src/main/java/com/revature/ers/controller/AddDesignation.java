package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.dto.Designation;
import com.revature.ers.service.implementation.AdminServiceImplementation;

/**
 * Servlet implementation class AddDesignation
 */
public class AddDesignation extends HttpServlet {
	
	Logger log = Logger.getLogger("AddDesignation.class");
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDesignation() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Inside ADD DESIGNATION SERVLET");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("designame");
		Designation d = new Designation();
		d.setName(name);
		AdminServiceImplementation a_impl = new AdminServiceImplementation();
		int result = a_impl.addDesignation(d);
		if(result == 1) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Designation added Successfully ... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addDesignation.html';");
		    out.println("</script>");
		}
		else if(result == 2 ) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Duplicate Designation Found');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addDesignation.html';");
		    out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Error in adding Designation');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addDesignation.html';");
		    out.println("</script>");
		}
	}

}
