<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:column1>
	<t:error />
	
	<form class="form-signin" method="POST" action="register">
	   <h2 class="form-signin-heading">Sign up</h2>
	   <input name="email" type="text" class="form-control" placeholder="Email" autofocus="">
	   <input name="username" type="text" class="form-control" placeholder="Username">
	   <input type="password" class="form-control" placeholder="Password">
	   <button class="btn btn-lg btn-success btn-block" type="submit">Sign up</button>
	 </form>
</t:column1>