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
		<div class="col-lg-6">
			<img src="<t:url />/auction/image?id=${auction.id}"
				alt="${auction.title}" width=500px>
		</div>
		<div class="col-lg-6 pull-right product-meta">
			<form class="form-horizontal" method="post"
				action="<t:url/>/auction/bid">
				<input type="hidden" value="${synchronizer}" name="synchronizer"/>
				<ul class="list-group">
					<li class="list-group-item"><h4
							class="list-group-item-heading">${auction.category.name}</h4> <span
						class="list-group-item-text">Category</span></li>
					<li class="list-group-item"><h4
							class="list-group-item-heading">
							<c:if test="${auction.isRunning()}">
									${auction.timeLeft} minutes
								</c:if>
							<c:if test="${not auction.isRunning()}">
									This Auction has Ended	
								</c:if>
						</h4> <span class="list-group-item-text">Time Left</span></li>
					<c:if test="${context.userId == auction.author.id }">
						<li class="list-group-item"><h4
								class="list-group-item-heading">AU $${auction.reservePrice }</h4> <span
							class="list-group-item-text">Reserve Price</span></li>
					</c:if>
					<li class="list-group-item" style="background-color: #dff0d8"><h4
							class="list-group-item-heading">AU $${auction.currentPrice}</h4>
						<span class="list-group-item-text">Current Bid</span>
						<div class="row">
							<div class="col-lg-12">
								<c:if test="${context.userId != auction.author.id && auction.status == 1}">
									<c:choose>
										<c:when
											test="${context.authenticated and auction.isRunning()}">
											<div class="form-group">
												<div class="col-lg-5 col-lg-offset-2">
													<input name="bid.auctionid" type="hidden"
														value="${auction.id}"> <input name="bid.price"
														type="text" class="form-control"
														placeholder='Enter $${auction.getNextBid()} or more'>
												</div>
												<div class="col-lg-4 col-lg-offset-1">
													<button class="btn btn-info" type="submit">
														<i class="icon-hand-up"></i> Place Bid
													</button>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<c:if test="${auction.isRunning()}">
												<span class="text-muted">Please Log in to place a
													bid.</span>
											</c:if>
										</c:otherwise>
									</c:choose>
								</c:if>
							</div>
						</div></li>
					<li class="list-group-item"><h4
							class="list-group-item-heading">${auction.postageDetails}</h4> <span
						class="list-group-item-text">Postage Details</span></li>
				</ul>

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