package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.dto.Type;
import com.revature.ers.service.implementation.AdminServiceImplementation;

/**
 * Servlet implementation class AddType
 */
public class AddType extends HttpServlet {
	
	Logger log = Logger.getLogger("AddType.class");
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddType() {
        super();
    }

	// TO ADD TYPE IN TYPE ENTITY.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("Inside ADD TYPE SERVLET");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("typename");
		Type t = new Type();
		t.setName(name);
		AdminServiceImplementation a_impl = new AdminServiceImplementation();
		int result = a_impl.addType(t);
		if(result == 1) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Type added Successfully ... :)');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addType.html';");
		    out.println("</script>");
		}
		else if(result == 2 ) {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Duplicate Type Found');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addType.html';");
		    out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Error in adding type');");
		    out.println("location='http://localhost:8080/reimbursement/htmls/admin/addType.html';");
		    out.println("</script>");
		}
	}

}
