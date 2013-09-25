<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:column1>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(function() {
				$('.table-hover tr').click(
						function() {
							var rowId = $(this).attr("row-key");
							window.location.href = "${pageContext.request.contextPath}/auction/view?id="
									+ rowId;
						});
			});
		</script>
	</jsp:attribute>
	<jsp:body>
	<div class="page-header">
		<h1 id="searchheader">Search Results</h1>
	</div>

	<table class="table table-hover">
		<c:forEach items="${searchResult.resultSet}" var="result">
			<tr row-key="${result.id }">
				<td style="border-top: none; padding: 20px;">
						<div class="media">
							<a class="pull-left" href="#"> <img class="media-object"
								data-src="holder.js/64x64" alt="64x64"
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACsUlEQVR4Xu2Y24upYRTGl0PI0JSimHDjMIVETVMzpvzrziLSTIkiLpTcjJLzcfaziuz2Njufsb8La93o+3jX+65nHX55NZ+fnzu6YdOIAFIB0gIyA254BpIMQaGAUEAoIBQQCtywAoJBwaBgUDAoGLxhCMifIcGgYFAwKBgUDAoGb1iBizHYbDap3+/Tbrcjp9NJwWCQNBrNQdJflKF6vU5ms5lisdhv353S/Ro+T+11kQCNRoN6vR7p9Xr2v16vyev1kt/v52eIkkql+L3BYKBEIkFarfbberuGz+82VCzAZrOhdDrNGX17e6PVakXdbpesVis9PDzwnq1Wi9/BTCYTvb6+0mQyoff3d9LpdBSPx2k8HhOCNhqNFIlEKJvNnu3zuOLO7WbFAiyXSz7sdrvloOfzObdAIBDgM8xmM8rlcuTxeGg0GtF0OmWhcNhKpULD4ZBsNhuvw3eoGqxX6vPcwPe/VywAertarbIftADKHIYgQqEQB4nAk8kklUolWiwWBwGOxcOa+/t7enp6okt8/ncBkOF8Ps+l+/LywlksFovc6+FwmMW5u7sjt9tN7XabK8Xn8/EzrNPp8HvY8/MzV9GlPpWIoLgCkHHMAPQ2BNg/Q4DHx0eq1Wp/nAcDEBWB4ZjJZA5VY7fbKRqNHnwo8fmv4XpKHMUCIAhUALLmcrn4E33tcDi4AlDmMBysXC5zcMg0gvv4+KDBYEAWi4UrB9WBAYi1Sn0qyT7WKBYAizHACoUCgQgwtAN6GUEeG1oDAoACmAsQZE8PCAHuY47saXKuT1UocBwgUAZDRn/KruHzb2e7qAJ+Klg1/YgAciMkN0JyIyQ3QmpOYbX3FgoIBYQCQgGhgNqTWM39hQJCAaGAUEAooOYUVntvoYBQQCggFBAKqD2J1dxfKHDrFPgCDLCNn09hb34AAAAASUVORK5CYII="
								style="width: 64px; height: 64px;">
							</a>
							<div class="media-body">
								<h4 class="media-heading">${result.title}</h4>
								${result.shortDescription}
							</div>
						</div>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${searchResult.isEmpty()}">
			<tr class="warning">
				<td>Sorry, no results found!</td>
			</tr>
		</c:if>
	</table>
	<ul class="pager">
		<li
				class='previous <c:if test="${not searchResult.hasPrevious()}">disabled</c:if>'><a
				href="<c:if test='${ searchResult.hasPrevious()}'>${pageContext.request.contextPath}/search?q=${searchResult.query }&page=${searchResult.page -1}</c:if>#">&larr; Previous</a></li>
		<li
				class='next <c:if test="${not searchResult.hasNext()}">disabled</c:if>'><a
				href="<c:if test='${ searchResult.hasNext()}'>${pageContext.request.contextPath}/search?q=${searchResult.query }&page=${searchResult.page +1}</c:if>#">Next &rarr;</a></li>
	</ul>
	</jsp:body>
</t:column1>