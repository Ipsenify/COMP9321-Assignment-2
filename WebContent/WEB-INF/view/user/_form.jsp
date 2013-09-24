<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<c:set var="script" scope="request">
	/*$(document).ready(function() {
		$("#form").validate();
     });

	$("#inputFirstName" ).rules( "add", {
	  required: true,
	  messages: {
	    required: "Required input"
	  }
	});*/

	$("#inputConfirmPassword").blur(function() 
	{
	 var password = $("#inputPassword").val();
	 var confirm = $("#inputConfirmPassword").val();
	 if(password != confirm) 
	    $("#confirmpasswordspan").html('Passwords don\'t match');  
	 else
	    $("#confirmpassswordpan").html('');  
	});
	
	$("#inputEmail").blur(function() 
	{
	 var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;  
	 var emailaddress = $("#inputEmail").val();
	 if(!emailReg.test(emailaddress)) 
	    $("#emailspan").html('<font color="#cc0000">Please enter a valid Email address</font>');  
	 else
	    $("#emailspan").html('<font color="#cc0000"></font>');  
	});
	
	$("#inputUsername").blur(function(){
		var username = $("#inputUsername").val();
		var request = $.ajax({
		  url: "user/validateusername",
		  type: "POST",
		  data: { username : username },
		  dataType: "json"
		});
		request.done(function( json ) {
			if(json.result == "false") {
				$("#inputUsername").parent().addClass("has-success");
				$("#usernamespan").html('<font color="#cc0000"></font>');  
			}else{
				$("#inputUsername").parent().addClass("has-error");
				$("#usernamespan").html('<font color="#cc0000">Username taken</font>');  
			}
		});
	});
</c:set>

<div class="form-group">
	<label for="inputFirstName" class="col-lg-2 control-label">Name</label>
	<div class="col-lg-5">
		<input name="user.firstName" value="${user.firstName}" type="text" class="form-control"
			id="inputFirstName" placeholder="First Name">
	</div>
	<div class="col-lg-5">
		<input name="user.lastName" value="${user.lastName}" type="text" class="form-control"
			id="inputLastName" placeholder="Last Name">
	</div>
</div>
<div class="form-group">
	<label for="inputEmail" class="col-lg-2 control-label">Email</label>
	<div class="col-lg-10">
		<input name="user.email" value="${user.email}" type="text" class="form-control" id="inputEmail"
			placeholder="Email">
			<span id="emailspan"></span>
	</div>
</div>

<div class="form-group">
	<label for="inputUsername" class="col-lg-2 control-label">Username</label>
	<div class="col-lg-10">
		<input name="user.userName" value="${user.userName}" type="text" class="form-control" id="inputUsername"
			placeholder="Username" <c:if test="${user.getId() != null}" >disabled</c:if>>
			<span id="usernamespan"></span>
	</div>
</div>

<c:if test="${user.getId() == null}" >
<div class="form-group">
	<label for="inputPassword" class="col-lg-2 control-label">Password</label>
	<div class="col-lg-10">
		<input  name="user.password" type="password" class="form-control" id="inputPassword"
			placeholder="Password">
	</div>
</div>

<div class="form-group">
	<label for="inputConfirmPassword" class="col-lg-2 control-label">Confirm Password</label>
	<div class="col-lg-10">
		<input name="user.confirmPassword" type="password" class="form-control" id="inputConfirmPassword"
			placeholder="Confirm Password">
			<span class="help-inline" id="confirmpasswordspan"></span>
	</div>
</div>
</c:if>

<div class="form-group">
	<label for="textArea" class="col-lg-2 control-label">Address</label>
	<div class="col-lg-10">
		<textarea name="user.fullAddress" class="form-control" rows="3" id="fullAddress">${user.fullAddress}</textarea>
		<span class="help-block">Your Full Address</span>
	</div>
</div>
<div class="form-group">
	<label for="select" class="col-lg-2 control-label">Birth Year</label>
	<div class="col-lg-10">
		<select name="user.yearOfBirth" class="form-control" id="select">
			<option>Select Birth Year</option>
			<c:forEach begin="1900" end="2013" varStatus="loop">
				<c:set var="currentYear" value="${loop.index}" />
				<option <c:if test="${currentYear == user.yearOfBirth}">selected</c:if> value="${currentYear}">${currentYear}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label for="inputCreditCard" class="col-lg-2 control-label">Credit
		Card</label>
	<div class="col-lg-5">
		<input name="user.creditCardNumber" type="text" class="form-control" id="inputCreditCard"
			placeholder="**** **** **** ${user.getShortenedCreditCard()}">
	</div>
</div>
<div class="form-group">
	<div class="col-lg-10 col-lg-offset-2">
		<button class="btn btn-default">Cancel</button>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</div>