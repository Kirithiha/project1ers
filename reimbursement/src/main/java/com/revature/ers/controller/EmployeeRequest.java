package com.revature.ers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reavture.ers.dao.implementation.ReimburseDaoImplementation;
import com.revature.ers.entity.ReimburseEntity;

/**
 * Servlet implementation class EmployeeRequest
 */
public class EmployeeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeRequest() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("emailid");
		ReimburseDaoImplementation re = new ReimburseDaoImplementation();
		List<ReimburseEntity> list = re.getReimburseEntity(email);
	}

}
