<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="pageTitle" scope="request" value="iBuy"/>

<t:column2>
	<h1>Welcome ${user.getUserName()}</h1>	
	<h1>Email:  ${user.getEmail()}</h1>
</t:column2>
