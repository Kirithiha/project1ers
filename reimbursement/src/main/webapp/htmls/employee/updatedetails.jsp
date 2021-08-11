<%@ page language="java" import = "java.util.List, java.util.ArrayList,com.revature.ers.util.SelectUtil, com.revature.ers.entity.UserEntity,com.revature.ers.entity.DesignationEntity, com.reavture.ers.dao.implementation.UserDaoImplementation" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboard.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<%
			String username = (String)session.getAttribute("username");
		%>
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="homepage.jsp">Home</a></li>
                <li><a class="navbar-brand" href="reimbursement.jsp">Request Reimburse</a></li>
                <li><a class="navbar-brand" href="viewreimburse.jsp">View Request</a></li>
                <li><a class="navbar-brand" href="viewresolved.jsp">View Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewdetails.jsp">View and Update Profile</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> Welcome Employee</div> 
           <div class="info">
               <div>
                   <form class="row g-3" action="http://localhost:8080/reimbursement/UpdateEmployee" method="post">
                   		<%
						  		UserDaoImplementation ud = new UserDaoImplementation();
						    	List<UserEntity> l = ud.getUser(username);
						    	for(UserEntity u : l) {
				  		%>
                   		<div class="col-md-6">
							    <label class="form-label">User Name</label>
							    <input type="text" class="form-control" name="usr" value=<%=u.getUserName()%>>
							</div>
				  			<div class="col-md-6">
							    <label class="form-label">Email Id</label>
							    <input type="email" class="form-control" name="emailid" value=<%=u.getEmailid() %>>
							</div>
				  			<div class="col-md-4">
							    <label class="form-label">Phone Number</label>
							    <input type="text" class="form-control" name="phn" value=<%=u.getPhoneNumber() %>>
							</div>
				  			<%
								List<DesignationEntity> dlist=SelectUtil.getDesignation();
							 %>
							 <div class="col-md-6">
							    <label class="form-label">Designation</label>
							    <select class="form-control" name="Designation">
									<option value=<%=u.getDesignation() %>><%= u.getDesignation() %></option>
									<%
										for(DesignationEntity t : dlist){
									%>
									<option value=<%=t.getName() %>><%= t.getName()%></option>
								   <% } %>
								</select>
							</div>
							<br/>
							<div class="col-md-8">
							    <label class="form-label">Account Number</label>
							    <input type="text" class="form-control" name="act" value=<%=u.getAccountNumber() %>>
							</div>
				  			<div class="col-md-6">
							    <label class="form-label">Branch Name</label>
							    <input type="text" class="form-control" name="branch" value=<%=u.getBranchName() %>>
							</div>
							<div class="col-md-6">
							    <label class="form-label">IFSC Code</label>
							    <input type="text" class="form-control" name="code" value=<%=u.getIfscCode() %>>
							</div>	
			            <%
						    }
				  		%> 		
                   		<div class="group">
		                   	<input class="btn btn-primary" id="submit" type="submit" value="Save Updates"> 
			            </div>
                   </form>
               </div>
           </div>
        </div>
    </div>
</body>
</html>