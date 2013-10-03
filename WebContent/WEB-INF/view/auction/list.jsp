<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:column1>
	<jsp:attribute name="javascript">
	</jsp:attribute>
	<jsp:body>
	<div class="page-header">
		<h1 id="myauctions">My Auctions</h1>
	</div>

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
		<c:forEach items="${auctions}" var="auction">
			<tr <c:if test="${auction.isRunning() }">class="success"</c:if>>
				<td> <a href="<t:url />/auction/view?id=${auction.id }">#${auction.id }</a> </td>
				<td> ${auction.title}</td>
				<td>${auction.category.name} </td>
				<td> $${auction.reservePrice} </td>
				<td> $${auction.currentPrice} </td>
				<td>
				</td>
				<td>
					<a href="<t:url />/auction/view?id=${auction.id}" class="btn btn-sm btn-primary"><i class="icon-eye-open"></i></a>
					<a href="<t:url />/auction/update?id=${auction.id}" class="btn btn-sm btn-primary"><i class="icon-edit"></i></a>
					<a class="btn btn-sm btn-primary"><i class="icon-trash"></i></a>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${auctions.isEmpty()}">
			<tr class="warning">
				<td>You have no auctions.. Create one now.</td>
			</tr>
		</c:if>
	</table>
	</jsp:body>
</t:column1>