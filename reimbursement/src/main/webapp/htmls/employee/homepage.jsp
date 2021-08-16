<%@ page language="java" import = "com.reavture.ers.dao.implementation.ReimburseDaoImplementation, com.revature.ers.entity.ReimburseEntity, com.reavture.ers.dao.implementation.UserDaoImplementation, com.revature.ers.entity.UserEntity, java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../../Css/dashboard.css" rel="stylesheet" type="text/css">
<link href="../../Css/counter.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		HttpSession sess = request.getSession(false);
		String username = (String)sess.getAttribute("username");
	%>
	<div class="wrapper">
        <div class="sidebar">
            <ul>
                <li><a class="navbar-brand" href="#">Home</a></li>
                <li><a class="navbar-brand" href="reimbursement.jsp">Request Reimburse</a></li>
                <li><a class="navbar-brand" href="viewreimburse.jsp">View Request</a></li>
                <li><a class="navbar-brand" href="viewresolved.jsp">View Resolved Request</a></li>
                <li><a class="navbar-brand" href="viewdetails.jsp">View and Update Profile</a></li>
                <li><a class="navbar-brand" href="http://localhost:8080/reimbursement/Logout">Logout</a></li>
            </ul>
        </div>
        <div class="main_container">
           <div class="header"> <h4 style="text-align:center;">Welcome Employee</h4> </div> 
           <div class="info">
               <div>
                   <div class="container">
                   <div class="column">
                   <h4>What is Reimburse</h4>
                   	<p style="margin-left:20px;"> Reimbursed expenses represent a cost to the company and personal income to you when you claim them back.
                   	ERS is a process of reimbursing your expenses incurred on company time. 
                   	To keep your accounts in order, you should record and track all reimbursed expenses.</p>
                   	<h4>You can do</h4>
                   	<p style="margin-left:20px;">Here you can add reimburse request, check for approved request, check for pending request and view and update your details</p>
                   </div>
				    <div class="column">
				    	<h4>Your request </h4>
				    	<form class="row g-3">
				    	<%
						  	ReimburseDaoImplementation re = new ReimburseDaoImplementation();
						  	List<ReimburseEntity> l = re.getReimburseEntity(username);
						  	int aRequest = l.size();
						  	l = re.approveById(username);
						  	int approve = l.size();
						  	l = re.pendingById(username);
						  	int pending = l.size();
						%>
				        <div class="col-md-6">
				            <div class="counter-box"> <span class="counter"><%=pending %></span>
				                <p>Pending Request</p>
				            </div>
				        </div>
				        <div class="col-md-6">
				            <div class="counter-box"> <span class="counter"><%=approve %></span>
				                <p>Resolved Request</p>
				            </div>
				        </div>
				        <div class="col-md-6">
				            <div class="counter-box"><span class="counter"><%=aRequest %></span>
				                <p>Total No of Request</p>
				            </div>
				        </div>
				       </form>
				    </div>
				</div>
               </div>
           </div>
        </div>
    </div>
</body>
</html>