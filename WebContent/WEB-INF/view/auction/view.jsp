<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<c:set var="pageTitle" scope="request" value="iBuy - ${auction.title}" />

<t:column1>
	<div class="row">
	
		<t:alerts />
		<div class="col-lg-12">
			<div class="page-header">
				<h1 id="nav">${auction.title}</h1>
			</div>
		</div>
		<div class="col-lg-4 product-image">
			<img src="${pageContext.request.contextPath}/theme/img/Capture.png"
				alt="${auction.title}">
		</div>
		<div class="col-lg-6 pull-right product-meta">
			<form class="form-horizontal" method="post" action="<t:url/>/auction/bid">

				<ul class="list-group">
					<li class="list-group-item"><h4
							class="list-group-item-heading">${auction.category.name}</h4> <span
						class="list-group-item-text">Category</span></li>
					<li class="list-group-item"><h4
							class="list-group-item-heading">10h 16m 43s (25 Sep, 2013
							11:37:01 AEST)</h4> <span class="list-group-item-text">Time
							Left</span></li>
					<li class="list-group-item" style="background-color:#dff0d8"><h4
							class="list-group-item-heading">AU $${auction.currentPrice}</h4> <span
						class="list-group-item-text">Current Bid</span>
						<div class="row">
							<div class="col-lg-12">
								<c:choose>
									<c:when test="${context.authenticated}">
										<div class="form-group">
											<div class="col-lg-4 col-lg-offset-2">
												<input name="bid.auctionid" type="hidden" value="${auction.id}">
												<input name="bid.price" type="text" class="form-control"
													placeholder="Enter $356.00 or more">
											</div>
											<div class="col-lg-4 col-lg-offset-1">
												<button class="btn btn-info" type="submit">
													<i class="icon-hand-up"></i> Place Bid
												</button>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<span class="text-muted">Please Log in to place a bid.</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div></li>
					<li class="list-group-item"><h4
							class="list-group-item-heading">${auction.postageDetails}</h4> <span
						class="list-group-item-text">Item Location</span></li>
				</ul>



				<table class="table">
					<tr>
						<td style="border-top: none;">Category</td>
						<td style="border-top: none;">${auction.category.name}</td>
					</tr>
					<tr>
						<td>Time Left</td>
						<td>10h 16m 43s (25 Sep, 2013 11:37:01 AEST)</td>
					</tr>
					<tr class="success">
						<td rowspan="2">Current Bid</td>
						<td><strong>AU $355.00</strong></td>
					</tr>
					<tr>
						<td class="success"><c:choose>
								<c:when test="${context.authenticated}">
									<div class="form-group">
										<div class="col-lg-6">
											<input type="text" class="form-control"
												placeholder="Enter $356.00 or more">
										</div>
										<div class="col-lg-4 col-lg-offset-2">
											<button class="btn btn-info" type="submit">
												<i class="icon-hand-up"></i> Place Bid
											</button>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<span class="text-muted">Please Log in to place a bid.</span>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>Item Location</td>
						<td>${auction.postageDetails}</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<hr />




	<div class="row">
		<div class="col-lg-12">
			<blockquote>${auction.description }</blockquote>
		</div>
	</div>
</t:column1>