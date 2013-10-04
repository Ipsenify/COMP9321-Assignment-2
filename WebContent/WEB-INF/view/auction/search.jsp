<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:column1>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(function() {
				$('.table-hover tr').click(
						function() {
							var rowId = $(this).attr("row-key");
							window.location.href = "${pageContext.request.contextPath}/auction/view?id="
									+ rowId;
						});
			});
		</script>
	</jsp:attribute>
	<jsp:body>
	<div class="page-header">
		<h1 id="searchheader">Search Results</h1>
	</div>

	<table class="table table-hover">
		<c:forEach items="${searchResult.resultSet}" var="result">
			<tr row-key="${result.id }">
				<td style="border-top: none; padding: 20px;">
						<div class="media">
							<a class="pull-left" href="#"> 
								<img class="media-object"
								src="<t:url />/auction/image?id=${result.id}"
								style="width: 64px; height: 64px;">
								<span class="label label-default">${result.category.name}</span>
							</a>
							<div class="media-body">
								<h2><span class="label label-info pull-right">$${result.currentPrice}</span></h2>
								<h4 class="media-heading">${result.title}</h4>
								${result.shortDescription}
							</div>
						</div>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${searchResult.isEmpty()}">
			<tr class="warning">
				<td>Sorry, no results found!</td>
			</tr>
		</c:if>
	</table>
	<ul class="pager">
		<li
				class='previous <c:if test="${not searchResult.hasPrevious()}">disabled</c:if>'><a
				href="<c:if test='${ searchResult.hasPrevious()}'>${pageContext.request.contextPath}/search?q=${searchResult.query }&page=${searchResult.page -1}</c:if>#">&larr; Previous</a></li>
		<li
				class='next <c:if test="${not searchResult.hasNext()}">disabled</c:if>'><a
				href="<c:if test='${ searchResult.hasNext()}'>${pageContext.request.contextPath}/search?q=${searchResult.query }&page=${searchResult.page +1}</c:if>#">Next &rarr;</a></li>
	</ul>
	</jsp:body>
</t:column1>