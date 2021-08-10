<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify All Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboardAdmin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="homepage.jsp">Home</a></li>
                <li><a class="navbar-brand" href="#">Verify Request</a></li>
                <li><a class="navbar-brand" href="resolvedrequest.jsp">View all Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewallrequest.jsp">View all Request</a></li>
                <li><a class="navbar-brand" href="employeerequest.jsp">View Employee Request</a></li>
                <li><a class="navbar-brand" href="addType.html">Add Reimburse Type</a></li>
                <li><a class="navbar-brand" href="addDesignation.html">Add Employee Designation</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> Welcome Employee</div> 
           <div class="info">
               <div>
               	<h4 style="text-align: center;font-family: Fantasy;"> All Resimbursed Request </h4><br/>
                   <table class="table" style="margin-left:6px">
					  <%
					  	
					  	ReimburseDaoImplementation re = new ReimburseDaoImplementation();
					  	List<ReimburseEntity> list = re.pending();
					  %>	
					  <thead>
					    <tr>
					      <th scope="col">Employee Id</th>
					      <th scope="col">Reimburse Type</th>
					      <th scope="col">Reason for Reimburse</th>
					      <th scope="col">Amount to be Reimburse</th>
					      <th scope="col">Amount Spent date</th>
					      <th scope="col">Applied date for Reimburse</th>
					      <th scope="col">Status</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<%
					  		for(ReimburseEntity r : list) {
					  	%>
					    <tr>
					      <td><%=r.getUser().getEmailid() %></td>
					      <td><%=r.getType() %></td>
					      <td><%=r.getReason() %></td>
					      <td><%=r.getAmount() %></td>
					      <td><%=r.getPurchasedDate() %></td>
					      <td><%=r.getAppliedDate() %></td>
					      <td><%=r.getStatus() %></td>
					      <td>
					      	<a href='edit.jsp?email=<%=r.getReimburseId() %>' class = "btn btn-warning">Verify</a>
					      </td>
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