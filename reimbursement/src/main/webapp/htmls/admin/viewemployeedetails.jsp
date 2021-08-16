<%@ page language="java"  import = "java.util.List, java.util.ArrayList, com.revature.ers.entity.UserEntity, com.revature.ers.entity.ReimburseEntity, com.reavture.ers.dao.implementation.UserDaoImplementation, com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.reavture.ers.dao.implementation.UserDaoImplementation" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee Details</title>
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
	                <li><a class="navbar-brand" href="employeerequest.jsp">View Employee Request</a></li>
	                <li><a class="navbar-brand" href="addType.html">Add Reimburse Type</a></li>
	                <li><a class="navbar-brand" href="addDesignation.html">Add Employee Designation</a></li>
	                <li><a class="navbar-brand" href="#">View Employee Details</a></li>
	                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
	            </ul>
	        </div>
	        <div class="main_container">
	           <div class="header"><h4 style="text-align:center;">Welcome Admin</h4></div> 
	           <div class="info">
	               <div>
               	<h4 style="text-align: center;font-family: Fantasy;"> All Employee Details </h4><br/>
                   <table class="table" style="margin-left:6px">
					  <%
					  	
					  	UserDaoImplementation re = new UserDaoImplementation();
					  	List<UserEntity> list = re.getAllUser();
					  %>	
					  <thead>
					    <tr>
					      <th scope="col">Employee Name</th>
					      <th scope="col">Email ID</th>
					      <th scope="col">Phone Number</th>
					      <th scope="col">Designation</th>
					      <th scope="col">Account Number</th>
					      <th scope="col">Branch Name</th>
					      <th scope="col">IFSC Code</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<%
					  		for(UserEntity r : list) {
					  			ReimburseDaoImplementation re_impl = new ReimburseDaoImplementation();
							  	List<ReimburseEntity> l = re_impl.getReimburseEntity(r.getEmailid());
					  	%>
					    <tr>
					      <td><%=r.getUserName() %></td>
					      <td><%=r.getEmailid() %></td>
					      <td><%=r.getPhoneNumber() %></td>
					      <td><%=r.getDesignation() %></td>
					      <td><%=r.getAccountNumber() %></td>
					      <td><%=r.getBranchName() %></td>
					      <td><%=r.getIfscCode() %></td>
					    </tr>
					    <%
					  		}
					    %>
					  </tbody>
					</table>
               </div>
	           </div>
	        </div>
	    </div>
</body>
</html>