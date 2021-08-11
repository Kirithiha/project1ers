<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboardAdmin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="homepage.jsp">Home</a></li>
                <li><a class="navbar-brand" href="verify.jsp">Verify Request</a></li>
                <li><a class="navbar-brand" href="resolvedrequest.jsp">View all Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewallrequest.jsp">View all Request</a></li>
                <li><a class="navbar-brand" href="#">View Employee Request</a></li>
                <li><a class="navbar-brand" href="addType.html">Add Reimburse Type</a></li>
                <li><a class="navbar-brand" href="addDesignation.html">Add Employee Designation</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"><h4 style="text-align:center;">Welcome Admin</h4></div> 
           <div class="info">
               <div>
                   <form action="viewemployeerequest.jsp">
                   		<h4 style="text-align: center;font-family: Fantasy;"> Employee Request </h4><br/>
						<div class="form-group col-md-6" style="margin-left:220px">
					      <label for="inputEmail">Email Id</label>
					      <input type="text" class="form-control" name="emailid" placeholder="Enter the employee emailid" required autofocus>
					    </div>
					    <button type="submit" style="margin-left:410px" class="btn btn-primary">Get Request</button>
					</form>
               </div>
           </div>
        </div>
    </div>
</body>
</html>