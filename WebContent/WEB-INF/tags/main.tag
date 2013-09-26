<%@tag description="Main Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@attribute name="javascript" fragment="true" required="false" %>

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
<link href="<t:url />/theme/css/bootstrap.min.css" rel="stylesheet"
	media="screen">

<link rel="stylesheet" href="<t:url />/theme/css/font-awesome.css">
<!--[if IE 7]>
  <link rel="stylesheet" href="<t:url />/css/font-awesome-ie7.css">
<![endif]-->

<!-- Custom styles for this template -->
<link href="<t:url />/theme/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="<t:url />/theme/js/html5shiv.js"></script>
      <script src="<t:url />/theme/js/respond.min.js"></script>
    <![endif]-->
<style>
${
css


}
</style>
<script type="text/javascript">
	$
	{
		headscript
	}
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
						<ul class="nav navbar-nav full pull-right">
							<li class="dropdown"><a href="#"
								class="dropdown-toggle hidden-xs hidden-sm"
								data-toggle="dropdown"> <i class="glyphicon glyphicon-user"></i> ${context.user.fullName } <b
									class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li role="presentation" class="dropdown-header">Your
										Account</li>
									<li><a href="<t:url />/user/view">Profile</a></li>
									<li><a href="<t:url />/my/auctions">My Auctions</a></li>
									<li><a href="<t:url />/site/settings">Settings</a></li>
									<li><a href="<t:url />/logout">Logout</a></li>
								</ul></li>

						</ul>
					</c:when>
					<c:otherwise>
						<form class="navbar-form navbar-right" method="POST"
							action="<t:url />/login">
							<input name="redirectUrl" type="hidden" value="${currentaction }">
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
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$
		{
			script
		}

	</script>
	<jsp:invoke fragment="javascript"/>
</body>
</html>