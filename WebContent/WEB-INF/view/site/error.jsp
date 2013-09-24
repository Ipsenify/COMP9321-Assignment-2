<%@ page isErrorPage="true"%>
<%@ page isErrorPage="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy - Error" />

<t:column1>
	<div class="container">
		<div class="jumbotron">
			<h1>${pageContext.errorData.statusCode}</h1>
			<p class="lead">
				That's an error. <br /> ${pageContext.exception.message} <br />
			</p>
			<p>
				<a class="btn btn-sm btn-info" href="<t:url />/home">Go Home</a>
			</p>
		</div>

		<ul class="footer-links">
			<li><a href="mailto:support@ibuy.com">Contact Support</a></li>
			<li class="muted">.</li>
			<li><a href="https://twitter.com/ibuy">@ibuy</a></li>
		</ul>
	</div>

</t:column1>
