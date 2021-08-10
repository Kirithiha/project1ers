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
           <div class="header"> Welcome Employee</div> 
           <div class="info">
               <div>
                   <form>
                   		<table class="table">
                   			<%
						  		UserDaoImplementation ud = new UserDaoImplementation();
						    	List<UserEntity> l = ud.getUser(username);
						    	for(UserEntity u : l) {
				  			%>
				  			<tr>
						   		<td>
								<label for="usr" class="label">User Name</label> 
								</td>
								<td>
								<input id="usr" type="text" class="input" name="usr"  value=<%=u.getUserName() %> disabled readonly> 
								</td>
						   	</tr>
				  			<tr>
								<td>
								<label for="user" class="label">EmailId</label> 
								</td>
								<td>
								<input id="user" type="email" name ="emailid" class="input" value=<%=u.getEmailid() %> disabled readonly>
								</td>
							</tr>
				  			<tr>
								<td>
							    <label for="phn" class="label">Phone Number</label> 
							    </td>
							    <td>
							    <input id="phn" type="text" name ="phn" class="input" value=<%=u.getPhoneNumber()%> disabled readonly>
							    </td>
							</tr>
				  			<%
								List<DesignationEntity> dlist=SelectUtil.getDesignation();
							 %>
				  			<tr>
								<td>
								<label for="type" class="label">Designation</label>
								</td>
								<td>
								<select class="input" id="type" name="Designation">
									<option value=<%=u.getDesignation() %>><%= u.getDesignation() %></option>
									<%
										for(DesignationEntity t : dlist){
									%>
									<option value=<%=t.getName() %>><%= t.getName()%></option>
								   <% } %>
								</select>
								</td>
							</tr>
				  			<tr>
								<td>
						        <label for="acct" class="label">Account Number</label> 
						        </td>
						        <td>
						        <input id="act" type="text" class="input" name="act"  value=<%=u.getAccountNumber() %> disabled readonly>
						        </td> 
						    </tr>
				  			<tr>
						 		<td>
						        <label for="branch" class="label">Branch Name</label> 
						        </td>
						        <td>
						        <input id="branch" type="text" class="input" name="branch" value=<%= u.getBranchName()%> disabled readonly> 
						        </td>
						   </tr>
				  		   <tr>
					 			<td>
						        <label for="code" class="label">IFSC Code</label> 
						        </td>
						        <td>
						        <input id="code" type="text" class="input" name="code" value=<%=u.getIfscCode() %> disabled readonly> 
						        </td>
					 	   </tr> 		
                   		</table>
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