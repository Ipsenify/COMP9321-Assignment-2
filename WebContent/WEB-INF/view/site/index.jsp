<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy" />

<t:column1>
	<form id="search-form" method="GET" action="<t:url/>/search" class="form-inline">
		<div class="jumbotron">
			<div class="container">
				<h1>Welcome to iBuy!</h1>
				<p>Search for an auction..</p>
				<div class="row">
					<div class="col-lg-12">
						<div class="input-group">
							<input id="search-input" name="q" type="text" class="form-control"
								placeholder="Search"> <span class="input-group-btn">
								<button class="btn btn-primary" type="submit">
									<i class="icon-search"></i>
								</button>
							</span>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</t:column1>