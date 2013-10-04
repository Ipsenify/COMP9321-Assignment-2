<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy Admin - Auctions" />

<t:admin>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(document).ready(function() {
				$('button.ban').click(function(event) {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/admin/users/banuser',
						data : {
							id : $(this).parent().parent().attr('row-key')
						}
					}).done(function() {
						location.reload();
					});
				});
				
				$('button.unban').click(function(event) {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/admin/users/unbanuser',
						data : {
							id : $(this).parent().parent().attr('row-key')
						}
					}).done(function() {
						location.reload();
					});
				});

			});
		</script>
	</jsp:attribute>
	<jsp:body>
	
	<div class="col-lg-12">
		<div class="page-header">
			<h1 id="nav">Users</h1>
		</div>
	</div>


	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Search for a user</h3>
		</div>
		<div class="panel-body">

			<form class="form-inline" method="GET">
				  <div class="form-group">
				  <input id="search-input" value="${results.query}" name="q"
							type="text" class="form-control" placeholder="Search Username" />
				  </div>
					<button class="btn btn-info" type="submit">
						<i class="icon-search"></i> Search
					</button>
				</form>
		</div>	
	</div>


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Users</h3>
		</div>
		<div class="panel-body">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Username</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Date Registered</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${results.resultSet}" var="user">
					<tr row-key="${user.id}"
							<c:if test="${user.status == 1 }">class="success"</c:if>
							<c:if test="${user.status == 0 }">class="warning"</c:if>
							<c:if test="${user.status == -1 }">class="danger"</c:if>>
						<td>#${user.id}</td>
						<td><a href="#">${user.userName}</a></td>
						<td>${user.fullName}</td>
						<td>${user.email}</td>
						<td>${user.created_at}</td>
						<td>${user.statusMessage } </td>
						<td>
							<c:if test="${user.status != -1 }">
								<button class="ban btn btn-sm btn-danger">
									<i class="icon-ban-circle"></i> Ban User
								</button>
							</c:if>
							<c:if test="${user.status == -1 }">
								<button class="unban btn btn-sm btn-success">
									<i class="icon-ok-circle"></i> Un-Ban User
								</button>
							</c:if>
							</td>
					</tr>
				</c:forEach>
				<c:if test="${auctions.isEmpty()}">
					<tr class="warning">
						<td></td>
					</tr>
				</c:if>
			</table>

		</div>
	</div>

	</jsp:body>
</t:admin>