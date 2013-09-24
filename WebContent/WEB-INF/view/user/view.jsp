<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:column2>
	<jsp:attribute name="sidebar">
	<div class="row profile">
      	<div class="col-lg-12">
			<h4>Registration date</h4>
			<p>${user.created_at}</p>
			
			<h4>Status</h4>
			<p>${user.getStatusMessage()}</p>
		</div>
      </div>
    </jsp:attribute>
	<jsp:body>
    
	<div class="jumbotron">
		<h1>${user.fullName}</h1>
		<p class="lead">${user.email}</p>
		<p>
			<a class="btn btn-sm btn-info" href="<t:url />/user/update">Update Profile</a>
		</p>
	</div>

	<div class="row profile">
		<div class="col-lg-6">
			<h4>First Name</h4>
			<p>${user.firstName}</p>

			<h4>Last Name</h4>
			<p>${user.lastName}</p>
		</div>
		<div class="col-lg-6">
			<h4>Nickname</h4>
			<p>${user.nickName}</p>
			
			<h4>Born</h4>
			<p>${user.yearOfBirth}</p>
		</div>
		<div class="col-lg-12">
			<h4>Address</h4>
			<p>${user.fullAddress}</p>
		</div>
	</div>
    
    </jsp:body>
</t:column2>
