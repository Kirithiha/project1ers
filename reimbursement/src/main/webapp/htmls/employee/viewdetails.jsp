<%@ page language="java" import = "java.util.List, java.util.ArrayList,com.revature.ers.util.SelectUtil, com.revature.ers.entity.UserEntity,com.revature.ers.entity.DesignationEntity, com.reavture.ers.dao.implementation.UserDaoImplementation" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Details </title>
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
                <li><a class="navbar-brand" href="reimbursement.jsp?username=<%=username%>">Request Reimburse</a></li>
                <li><a class="navbar-brand" href="viewreimburse.jsp">View Request</a></li>
                <li><a class="navbar-brand" href="viewresolved.jsp">View Resolved Request</a></li>
                <li><a class="navbar-brand" href="#">View and Update Profile</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> <h4 style="text-align:center;">Welcome Employee</h4> </div> 
           <div class="info">
           		<h4 style="text-align: center;font-family: Fantasy;"> Your Details </h4><br/>
               <div>
					<form class="row g-3">
                   			<%
						  		UserDaoImplementation ud = new UserDaoImplementation();
						    	List<UserEntity> l = ud.getUser(username);
						    	for(UserEntity u : l) {
				  			%>
				  			<div class="col-md-6">
							    <label class="form-label">User Name</label>
							    <input type="text" class="form-control" name="username" value=<%=u.getUserName()%> disabled readonly>
							</div>
				  			<div class="col-md-6">
							    <label class="form-label">Email Id</label>
							    <input type="email" class="form-control" name="email" value=<%=u.getEmailid() %> disabled readonly>
							</div>
				  			<div class="col-md-4">
							    <label class="form-label">Phone Number</label>
							    <input type="text" class="form-control" name="phn" value=<%=u.getPhoneNumber() %> disabled readonly>
							</div>
				  			<%
								List<DesignationEntity> dlist=SelectUtil.getDesignation();
							 %>
							 <div class="col-md-6">
							    <label class="form-label">Designation</label>
							    <select class="form-control" name="Designation" disabled>
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
							    <input type="text" class="form-control" name="act" value='<%=u.getAccountNumber() %>' disabled readonly>
							</div>
				  			<div class="col-md-6">
							    <label class="form-label">Branch Name</label>
							    <input type="text" class="form-control" name="branch" value=<%=u.getBranchName() %> disabled readonly>
							</div>
							<div class="col-md-6">
							    <label class="form-label">IFSC Code</label>
							    <input type="text" class="form-control" name="code" value=<%=u.getIfscCode() %> disabled readonly>
							</div>	
                   		<div class="group">
		                   	<a href='updatedetails.jsp' id="submit" class = "btn btn-primary">Update</a>
			            </div>
			            <%
						    }
				  		%> 	
                   </form>
               </div>
           </div>
        </div>
    </div>
</body>
</html>