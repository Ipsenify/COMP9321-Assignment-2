<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:column1>
	<div class="well">

		<t:error />

		<form class="form-horizontal">
			<fieldset>
				<legend>Update Profile</legend>
				<%@include file="_form.jsp"%>
			</fieldset>
		</form>
	</div>
</t:column1>