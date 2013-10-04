<%@tag description="Main Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@attribute name="javascript" fragment="true" required="false"%>

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

<link rel="stylesheet" href="<t:url />/theme/css/slider.css">
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
				<a class="navbar-brand" href="<t:url />/admin/">iBuy Admin</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<t:url />/home">Home</a></li>
					<li><a href="<t:url />/search">Search</a></li>
				</ul>

				<form class="navbar-form navbar-right">
					<a href="<t:url />/admin/logout" class="btn btn-danger">Logout</a>
				</form>
			</div>

			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar -->

	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn" data-toggle="offcanvas">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</p>
				<div class="row">

					<jsp:doBody />

				</div>

			</div>
			<!--/span-->

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				role="navigation">
				<div class="well sidebar-nav">
					<ul class="nav">
						<li>Administration</li>
						<li><a href="<t:url />/admin/users/">Users</a></li>
						<li><a href="<t:url />/admin/auctions/">Auctions</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>

		</div>


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
		src="${pageContext.request.contextPath}/theme/js/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/theme/js/jquery.validate.min.js"></script>
	<jsp:invoke fragment="javascript" />
</body>
</html>