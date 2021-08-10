<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, java.util.List, com.revature.ers.util.SelectUtil, com.revature.ers.entity.TypeEntity" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Reimburse Status</title>
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
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> Welcome Admin</div> 
           <div class="info">
               <div>
               		<%
               			ReimburseDaoImplementation re = new ReimburseDaoImplementation();
               			String  email = request.getParameter("email");
               			List<ReimburseEntity> list = re.getReimburseEntityById(email);
               			for(ReimburseEntity r : list) {
               		%>
                   	<form class="row g-3" action="http://localhost:8080/reimbursement/UpdateStatus" method="post">
                   	<input type="hidden" name="id" value=<%=email %>>
					  <div class="col-md-6">
					    <label for="inputEmail4" class="form-label">Email</label>
					    <input type="email" class="form-control" name="email" value=<%=r.getUser().getEmailid() %> placeholder="Enter email id">
					  </div>
					  <div class="col-md-6">
					    <label for="inputPassword4" class="form-label">Type of Reimbursement</label>
					    <select class="form-control" name="type">
							<option value=<%=r.getType() %>><%=r.getType() %></option>
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
					    <label class="form-label">Reason for Reimbursement</label>
					    <input type="text" class="form-control" name="reason" value=<%=r.getReason() %>>
					  </div>
					  <div class="col-md-6">
					    <label for="inputCity" class="form-label">Purchased Date</label>
					    <input type="date" class="form-control" name="date" value=<%=r.getPurchasedDate() %>>
					  </div>
					  <div class="col-sm">
					    <label for="inputZip" class="form-label">Amount</label>
					    <input type="text" class="form-control" name="amount" value=<%=r.getAmount() %>>
					  </div>
					  <div class="col-sm">
					    <label for="inputZip" class="form-label">Applied Date</label>
					    <input type="text" class="form-control" name="appDate" value=<%=r.getAppliedDate() %>>
					  </div>
					  <div class="col-sm">
					    <label for="inputZip" class="form-label">Status</label>
					    <input type="text" class="form-control" name="status" value=<%=r.getStatus() %>>
					  </div>
					  <div class="col-12">	
					  	<%
					  		String status = r.getStatus();	
					  	%>
					    <button type="submit" class="btn btn-primary" id="submit" name="action" value="approve">Approve</button>
					    <button type="submit" class="btn btn-primary" style="margin-left:100px"  name="action" value="deny">Reject</button>
					  </div>
					</form>
					<%
               			}
					%>
               </div>
           </div>
        </div>
    </div>
</body>
</html>