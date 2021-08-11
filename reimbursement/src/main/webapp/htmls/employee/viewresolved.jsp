<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Resolved Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboard.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String email = (String)session.getAttribute("username");
	%>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="homepage.jsp">Home</a></li>
                <li><a class="navbar-brand" href="reimbursement.jsp">Request Reimburse</a></li>
                <li><a class="navbar-brand" href="viewreimburse.jsp">View Request</a></li>
                <li><a class="navbar-brand" href="#">View Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewdetails.jsp">View and Update Profile</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> <h4 style="text-align:center;">Welcome Employee</h4> </div> 
           <div class="info">
           		<h4 style="text-align: center;font-family: Fantasy;"> Your Resolved Request </h4><br/>
               <div>
                   <table class="table" style="margin-left:6px">
					  <%
					  	
					  	ReimburseDaoImplementation re = new ReimburseDaoImplementation();
					  	List<ReimburseEntity> list = re.approveById(email);
					  %>	
					  <thead>
					    <tr>
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
					      <td><%=r.getType() %></td>
					      <td><%=r.getReason() %></td>
					      <td><%=r.getAmount() %></td>
					      <td><%=r.getPurchasedDate() %></td>
					      <td><%=r.getAppliedDate() %></td>
					      <td><%=r.getStatus() %></td>
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