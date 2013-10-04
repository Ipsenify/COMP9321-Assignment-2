<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy Admin - Auctions" />

<t:admin>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(document).ready(function() {
				$('select.changeStatus').change(function() {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/admin/auctions/updateauctionstatus',
						data : {
							status : $(this).val(),
							id : $(this).parent().parent().attr('row-key')
						}
					}).done(function() {
						location.reload();
					});
				});

				$('button.delete').click(function(event) {
					$.ajax({
						type : 'POST',
						url : '<t:url/>/admin/auctions/deleteauction',
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
			<h1 id="nav">Auctions</h1>
		</div>
	</div>


	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Search for an Auction</h3>
		</div>
		<div class="panel-body">

			<form class="form-inline" method="GET">
				  <div class="form-group">
				  <input id="search-input" value="${results.query}" name="q"
							type="text" class="form-control" placeholder="Search" />
				  </div>
				  <div class="form-group">
				    <select name="c" id="inputListingCategory" class="form-control"
							id="select">
							<option value="">Category</option>
							<c:forEach items="${categories}" var="category">
								<option
									<c:if test="${category.id.toString() eq results.category}">selected </c:if>
									value="${category.id}">${category.name}</option>
							</c:forEach>
						</select>
				  </div>
				  
					<button class="btn btn-info" type="submit">
						<i class="icon-search"></i> Search
					</button>
				</form>
		</div>	
	</div>


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Auctions</h3>
		</div>
		<div class="panel-body">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Author</th>
						<th>Title</th>
						<th>Category</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach items="${results.resultSet}" var="auction">
					<tr row-key="${auction.id}"
							<c:if test="${auction.status == 1 }">class="success"</c:if>
							<c:if test="${auction.status == 0 }">class="danger"</c:if>>
						<td><a href="<t:url />/auction/view?id=${auction.id }">#${auction.id
								}</a></td>
						<td><a href="#">${auction.author.userName}</a></td>
						<td>${auction.title}</td>
						<td>${auction.category.name}</td>
						<td>
						<select class="changeStatus"
								<c:if test="${auction.status > 1}">disabled</c:if>>
							<option <c:if test="${auction.status == 4 }">selected </c:if>
										value="4" disabled>Ended - Not Sold</option>
							<option <c:if test="${auction.status == 3 }">selected </c:if>
										value="3" disabled>Ended - Sold</option>
							<option <c:if test="${auction.status == 2 }">selected </c:if>
										value="2" disabled>Awaiting Approval</option>
							<option <c:if test="${auction.status == 1 }">selected </c:if>
										value="1">Active</option>
							<option <c:if test="${auction.status == 0 }">selected </c:if>
										value="0">Suspended</option>
						</select>
							</td>
						<td><a href="<t:url />/auction/view?id=${auction.id}"
								class="btn btn-sm btn-primary"><i class="icon-eye-open"></i></a>
							<button class="delete btn btn-sm btn-danger">
									<i class="icon-trash"></i>
								</button></td>
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