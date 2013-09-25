<%@ tag description="One Column Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@attribute name="javascript" fragment="true" required="false"%>

<t:main>
	<jsp:attribute name="javascript">
		<jsp:invoke fragment="javascript" />
	</jsp:attribute>
	<jsp:body>
	 <div class="column1">
	 	 <jsp:doBody />
	  </div>
	</jsp:body>
</t:main>