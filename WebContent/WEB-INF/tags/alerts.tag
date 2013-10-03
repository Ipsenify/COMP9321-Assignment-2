<%@tag description="Error" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="success" items="${successes}">
	<div class="alert alert-success">
	  <button type="button" class="close" data-dismiss="alert" area-hidden="true">&times;</button>
	  <strong>Well done!</strong> ${success}
	</div>
</c:forEach>

<c:forEach var="info" items="${infos}">
	<div class="alert alert-info">
	  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	  <strong>Heads up!</strong> ${info}
	</div>
</c:forEach>

<c:forEach var="warning" items="${warnings}">
	<div class="alert alert-warning">
	  <button type="button" class="close" data-dismiss="alert" area-hidden="true">&times;</button>
	  <strong>Warning!</strong> ${warning}
	</div>
</c:forEach>

<c:forEach var="error" items="${errors}">
	<div class="alert alert-danger">
	  <button type="button" class="close" data-dismiss="alert" area-hidden="true">&times;</button>
	  <strong>Error!</strong> ${error}
	</div>
</c:forEach>
