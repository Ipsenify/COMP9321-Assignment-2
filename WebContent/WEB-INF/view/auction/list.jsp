<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:column1>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(document).ready(function() {
				$('button.accept').change(function() {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/my/auctions/accept',
						data : {
							accept : 1,
							id : $(this).parent().parent().attr('row-key')
						}
					}).done(function() {
						location.reload();
					});
				});

				$('button.reject').click(function(event) {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/my/auctions/reject',
						data : {
							accept : 0,
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
	<div class="page-header">
		<h1 id="myauctions">My Auctions</h1>
	</div>

	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Active</h3>
		</div>
		<div class="panel-body">
		
		<table class="table table-hover">
		<thead>
          <tr>
            <th>#</th>
            <th>Title</th>
            <th>Category</th>
            <th>Reserve Price</th>
            <th>Current Price</th>
            <th>Status</th>
            <th></th>
          </tr>
        </thead>
		<c:forEach items="${active}" var="auction">
			<tr <c:if test="${auction.isRunning() }">class="success"</c:if>>
				<td> <a href="<t:url />/auction/view?id=${auction.id }">#${auction.id }</a> </td>
				<td> ${auction.title}</td>
				<td>${auction.category.name} </td>
				<td> $${auction.reservePrice} </td>
				<td> $${auction.currentPrice} </td>
				<td>${auction.statusMessage } </td>
				<td>
					<c:if test="${auction.status == 2 }">
						<button class="accept btn btn-sm btn-success">Accept</button>
						<button class="reject btn btn-sm btn-danger">Reject</button>
					</c:if>
					<a href="<t:url />/auction/view?id=${auction.id}"
								class="btn btn-sm btn-primary"><i class="icon-eye-open"></i></a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${auctions.isEmpty()}">
			<tr class="warning">
				<td>You have no auctions.. Create one now.</td>
			</tr>
		</c:if>
	</table>
		</div>
		
	</div>
	
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Archived</h3>
		</div>
		<div class="panel-body">
		
		<table class="table table-hover">
		<thead>
          <tr>
            <th>#</th>
            <th>Title</th>
            <th>Category</th>
            <th>Final Price</th>
            <th>Status</th>
            <th></th>
          </tr>
        </thead>
		<c:forEach items="${archived}" var="auction">
			<tr <c:if test="${auction.isRunning() }">class="success"</c:if>>
				<td> <a href="<t:url />/auction/view?id=${auction.id }">#${auction.id }</a> </td>
				<td> ${auction.title}</td>
				<td>${auction.category.name} </td>
				<td> $${auction.currentPrice} </td>
				<td>${auction.statusMessage } </td>
				<td>
					<a href="<t:url />/auction/view?id=${auction.id}"
								class="btn btn-sm btn-primary"><i class="icon-eye-open"></i></a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${auctions.isEmpty()}">
			<tr class="warning">
				<td>You have no auctions.. Create one now.</td>
			</tr>
		</c:if>
	</table>
		</div>
		
	</div>
	
	</jsp:body>
</t:column1>