<%@ tag description="One Column Layout" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="css" scope="request" value="body{background-color:#eee;}"/>

<t:main>
 <div class="column1">
 	 <jsp:doBody/>
  </div>
</t:main>