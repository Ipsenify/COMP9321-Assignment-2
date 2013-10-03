<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:column1>
	<jsp:attribute name="javascript">
		<%@include file="_form-js.jsp"%>
	</jsp:attribute>
	<jsp:body>
		<div class="well">

		<t:alerts />
		<form class="form-horizontal" method="POST">
			<fieldset>
				<legend>Update Profile</legend>
				<%@include file="_form.jsp"%>
			</fieldset>
		</form>
	</div>
	</jsp:body>
</t:column1>