<%@tag description="Two Column Layout" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@attribute name="javascript" fragment="true" required="false"%>
<%@attribute name="sidebar" fragment="true" required="false"%>

<t:main>
	<jsp:attribute name="javascript">
		<jsp:invoke fragment="javascript" />
	</jsp:attribute>
	<jsp:body>
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
    	<div class="sidebar-nav">
    		<jsp:invoke fragment="sidebar" />
    	</div>
    </div>
  </div>
		<!--/row-->
	</jsp:body>
</t:main>