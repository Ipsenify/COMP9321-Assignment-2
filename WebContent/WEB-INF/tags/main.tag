<%@tag description="Main Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">

<title>${pageTitle}</title>

<!-- Bootstrap core CSS -->
<link
	href="<t:url />/theme/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

<!-- Custom styles for this template -->
<link href="<t:url />/theme/css/style.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
<style>
${
css
}
</style>
<script type="text/javascript">
	${headscript}
</script>
</head>
<body style="">
	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<t:url />/home">iBuy</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<t:url />/home">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<c:choose>
					<c:when test="${context.isAuthenticated()}">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="<t:url />/user/view">G'day ${context.getUser().getFullName()}</a></li>
							<li><a class="btn btn-sm btn-danger" href="logout">Logout</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<form class="navbar-form navbar-right" method="POST"
							action="login">
							<div class="form-group">
								<input type="text" placeholder="Username" name="username"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="password" placeholder="Password" name="password"
									class="form-control">
							</div>
							<button type="submit" class="btn btn-success">Log in</button>
							<a href="register" class="btn btn-danger">Sign up</a>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar -->

	<div class="container">

		<jsp:doBody />

		<hr>

		<%@ include file="footer.jsp"%>

	</div>
	<!--/.container-->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/theme/js//jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/theme/js/offcanvas.js"></script>
	<script src="${pageContext.request.contextPath}/theme/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		${script}
	</script>
</body>
</html>