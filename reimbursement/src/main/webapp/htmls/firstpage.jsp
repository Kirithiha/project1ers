<%@ page language="java" import ="java.util.List, com.revature.ers.util.SelectUtil, com.revature.ers.entity.TypeEntity, com.revature.ers.entity.DesignationEntity" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reimbursement System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="../Css/firstpage.css" rel="stylesheet" type="text/css">
</head>
<body>
		<div class="row">
	    <div class="col-md-6 mx-auto p-0">
	        <div class="card">
	            <div class="login-box">
	                <div class="login-snip"> 
	                	<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
	                	<label for="tab-1" class="tab">Login</label> 
	                	<input id="tab-2" type="radio" name="tab" class="sign-up">
	                	<label for="tab-2" class="tab">Sign Up</label>
	                    <div class="login-space">
	                    <br/>
	                    <form action="http://localhost:8080/reimbursement/Login">
	                        <div class="login">
	                            <div class="group">
	                            	 <label for="user" class="label">Email Id</label> 
	                            	 <input id="user" type="email" class="input" name ="username" placeholder="Enter your emailid" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,}" required>
	                            </div>
	                            <div class="group">
		                             <label for="pass" class="label">Password</label> 
		                             <input id="pass" type="password" class="input" name="passwordLogin" data-type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Enter your password" required> 
	                            </div>
	                            <div class="group"> 
	                            	<input type="submit" class="button" value="Sign In"> 
	                            </div>
	                            <div class="hr"></div>
	                            <a href="forgetpassword.html">Forget Password</a>
	                        </div>
	         		 </form>
	          		<form class = "row g-3" action="http://localhost:8080/reimbursement/Signup" method="post">
	                        <div class="sign-up-form">
	                        		<div class="group">
	                            	 <label for="usr" class="label">User Name</label> 
	                            	 <input id="usr" type="text" class="input" name="usr"  placeholder="Enter your User name" required> 
	                           	</div>
	                            <div class="group">
	                            	 <label for="user" class="label">EmailId</label> 
	                            	 <input id="user" type="email" name ="emailid" class="input" placeholder="Enter you emailid" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,}" required>
	                            </div>
	                            <div class="group">
	                            	 <label for="phn" class="label">Phone Number</label> 
	                            	 <input id="phn" type="text" name ="phn" class="input" placeholder="Enter you Phone number" pattern="[0-9]{10}" title = "enter 10 digit" required>
	                            </div>
	                            <div class="group">
	                            	 <label for="pass" class="label">Password</label> 
	                            	 <input id="pass" type="password" class="input" name="passwdSignup" data-type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Enter your password" required>
	                            </div>
	                            <div class="group">
	                            	 <label for="pass" class="label">Repeat Password</label> 
	                            	 <input id="pass" type="password" class="input" name="repeatPass" data-type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" placeholder="Enter re-enter your password" required> 
	                           	</div>
								  <%
								  List<DesignationEntity> dlist=SelectUtil.getDesignation();
								  %>
								  <div class="group">
								    <label for="type" class="label">Designation</label>
								    <select class="input" id="type" name="Designation">
								    	<option>default value</option>
								     	<%
								     	for(DesignationEntity t : dlist){
								     	%>
								            <option value=<%=t.getName() %>><%= t.getName()%></option>
								        <% } %>
								    </select>
								  </div>
								  <div class="group">
	                            	 <label for="acct" class="label">Account Number</label> 
	                            	 <input id="act" type="text" class="input" name="act"  placeholder="Enter your Account Number" pattern="[0-9]{4} [0-9]{4} [0-9]{4}" title="enter the correct format xxxx xxxx xxxx" required> 
	                           	  </div>
	                           	<div class="group">
	                            	 <label for="branch" class="label">Branch Name</label> 
	                            	 <input id="branch" type="text" class="input" name="branch"  placeholder="Enter your branch Name" required> 
	                           	</div>
	                           	<div class="group">
	                            	 <label for="code" class="label">IFSC Code</label> 
	                            	 <input id="code" type="text" class="input" name="code" placeholder="Enter your IFSC code" pattern="[A-Z]{4}[0-9]{7}" title="enter correct format of AAAA0000000" required> 
	                           	</div>
	                            <div class="group"> 
	                            	<input type="submit" class="button" value="Sign Up"> 
	                            </div>
	                            <div class="hr"></div>
	                            <div class="foot"> <label for="tab-1">Already Member?</label> </div>
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