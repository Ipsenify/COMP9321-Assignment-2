<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy" />

<t:column1>
	<form id="search-form" method="GET" action="<t:url/>/search"
		class="form-inline">
		<div class="jumbotron">
			<div class="container">
				<h1>Welcome to iBuy!</h1>
				<p>Search for an auction..</p>
				<div class="row">
					<div class="col-lg-12">
						<input id="search-input" name="q" type="text" class="form-control"
							placeholder="Search" />
					</div>
					<div class="col-lg-6">
						<select name="c" id="inputListingCategory"
							class="form-control" id="select">
							<option value="">Category</option>
							<c:forEach items="${categories}" var="category">
								<option value="${category.id}">${category.name}</option>
							</c:forEach>
						</select>
					</div>

					<button class="btn btn-primary" type="submit">
						<i class="icon-search"></i> Search
					</button>

				</div>
			</div>
		</div>
	</form>
</t:column1>