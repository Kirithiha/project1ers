<%@ page language="java" import="com.revature.ers.util.SelectUtil, java.util.List, com.revature.ers.entity.TypeEntity" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursement Request</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboard.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String username = (String)session.getAttribute("username");
	%>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="homepage.jsp">Home</a></li>
                <li><a class="navbar-brand" href="#">Request Reimburse</a></li>
                <li><a class="navbar-brand" href="viewreimburse.jsp">View Request</a></li>
                <li><a class="navbar-brand" href="viewresolved.jsp">View Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewdetails.jsp">View and Update Profile</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> <h4 style="text-align:center;">Welcome Employee</h4> </div> 
           <div class="info">
           		<h4 style="text-align: center;font-family: Fantasy;"> Request for Reimburse </h4><br/>
               <div>
					<form class="row g-3" action="http://localhost:8080/reimbursement/ReimburseRequest" method="post">
					  <div class="col-md-6">
					    <label for="inputEmail4" class="form-label">Email</label>
					    <input type="email" class="form-control" name="email" value=<%=username %> placeholder="Enter email id">
					  </div>
					  <div class="col-md-6">
					    <label  class="form-label">Type of Reimbursement</label>
					    <select class="form-control" name="type">
							<option>Default Value</option>
							<%
								List<TypeEntity> dlist=SelectUtil.getTypes();
								for(TypeEntity t : dlist){
							%>
							<option value=<%=t.getName() %>><%= t.getName()%></option>
							<% 
								}
							%>
						</select>
					  </div>
					  <div class="col-12">
					    <label for="inputAddress" class="form-label">Reason for Reimbursement</label>
					    <input type="text" class="form-control" name="reason" placeholder="Enter the Reason for Reimburse" required>
					  </div>
					  <div class="col-md-6">
					    <label for="inputCity" class="form-label">Purchased Date</label>
					    <input type="date" class="form-control" name="date" placeholder="Enter the purchase date in DD-MM-YYYY" required>
					  </div>
					  <div class="col-sm">
					    <label for="inputZip" class="form-label">Amount</label>
					    <input type="text" class="form-control" name="amount" placeholder="Enter purchased amount" pattern="[0-9]{1,}.[0-9]{0,}"required>
					  </div>
					  <div class="col-12">
					    <button type="submit" class="btn btn-primary" id="submit">Submit</button>
					  </div>
					</form>
               </div>
           </div>
        </div>
    </div>
</body>
</html>