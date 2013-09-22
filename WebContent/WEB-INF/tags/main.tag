<%@tag description="Main Layout" pageEncoding="UTF-8"%>
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
    <link href="${pageContext.request.contextPath}/theme/css/bootstrap.min.css" rel="stylesheet" media="screen">  

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/theme/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    <style>
    	${css}
    </style>
</head>
  <body style="">
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="?action=home">iBuy</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          <form class="navbar-form navbar-right" method="POST" action="?action=login">
            <div class="form-group">
              <input type="text" placeholder="Username" name="username" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" name="password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">

		<jsp:doBody/>		

      <hr>
  	  
  	  <%@ include file="footer.jsp" %>

    </div><!--/.container-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    <script src="http://code.jquery.com/jquery.js"></script>  
    <script src="${pageContext.request.contextPath}/theme/js/bootstrap.min.js"></script>  
    <script src="${pageContext.request.contextPath}/theme/js/offcanvas.js"></script>
</body></html>