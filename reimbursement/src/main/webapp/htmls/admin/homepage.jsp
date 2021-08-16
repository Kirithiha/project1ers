<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, com.reavture.ers.dao.implementation.UserDaoImplementation, com.revature.ers.entity.UserEntity, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboardAdmin.css" rel="stylesheet" type="text/css">
<link href="../../Css/counter.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="#">Home</a></li>
                <li><a class="navbar-brand" href="verify.jsp">Verify Request</a></li>
                <li><a class="navbar-brand" href="resolvedrequest.jsp">View all Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewallrequest.jsp">View all Request</a></li>
                <li><a class="navbar-brand" href="employeerequest.jsp">View Employee Request</a></li>
                <li><a class="navbar-brand" href="addType.html">Add Reimburse Type</a></li>
                <li><a class="navbar-brand" href="addDesignation.html">Add Employee Designation</a></li>
                <li><a class="navbar-brand" href="viewemployeedetails.jsp">View Employee Details</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"><h4 style="text-align:center;">Welcome Admin</h4></div> 
           <div class="info">
               <div>
                   <div class="container">
				    <div class="row">
				    	<%
					    	UserDaoImplementation ue = new UserDaoImplementation();
						  	List<UserEntity> list = ue.getAllUser();
						  	int user = list.size();
						  	ReimburseDaoImplementation re = new ReimburseDaoImplementation();
						  	List<ReimburseEntity> l = re.getAll();
						  	int aRequest = l.size();
						  	l = re.approve();
						  	int approve = l.size();
						  	l = re.pending();
						  	int pending = l.size();
						%>
				        <div class="four col-md-3">
				            <div class="counter-box colored"> <span class="counter"><%=user %></span>
				                <p>No Of Employee</p>
				            </div>
				        </div>
				        <div class="four col-md-3">
				            <div class="counter-box"> <span class="counter"><%=pending %></span>
				                <p>Pending Request</p>
				            </div>
				        </div>
				        <div class="four col-md-3">
				            <div class="counter-box"> <span class="counter"><%=approve %></span>
				                <p>Resolved Request</p>
				            </div>
				        </div>
				        <div class="four col-md-3">
				            <div class="counter-box"><span class="counter"><%=aRequest %></span>
				                <p>Total No of Request</p>
				            </div>
				        </div>
				    </div>
				</div>
               </div>
           </div>
        </div>
    </div>
</body>
</html>