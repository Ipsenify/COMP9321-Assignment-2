<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:column1>
	<div class="well">
		<form class="form-horizontal">
			<fieldset>

				<div class="form-group">
					<label for="inputListingTitle" class="col-lg-2 control-label">Title</label>
					<div class="col-lg-5">
						<input value="${listing.title}" type="text" class="form-control"
							id="inputListingTitle" placeholder="Title (10 word limit)">
					</div>
				</div>
				<div class="form-group">
					<label for="inputListingCategory" class="col-lg-2 control-label">Category</label>
					<div class="col-lg-5">
						<input value="${listing.cagegory}" type="text"
							class="form-control" id="inputListingCategory"
							placeholder="Category">
					</div>
				</div>
				<div class="form-group">
                    <label for="inputListingPicture" class="col-lg-2 control-label">Add Photo</label>
                    <div class="col-lg-5">
	                    <input type="file" id="inputListingPicture">
	                    <p class="help-block">Select an image to accompany your listing.</p>
                    </div>
                </div>
				<div class="form-group">
					<label for="inputListingDescription" class="col-lg-2 control-label">Description</label>
					<div class="col-lg-10">
						<textarea class="form-control" rows="3" id="textArea"></textarea>
						<span class="help-block">Product Description (100 word limit)</span>
					</div>
				</div>
				<div class="form-group">
                    <label for="inputListingPostage" class="col-lg-2 control-label">Postage Details</label>
                    <div class="col-lg-5">
                        <input value="${listing.postage}" type="text"
                            class="form-control" id="inputListingPostage"
                            placeholder="Postage">
                    </div>
                </div>
				<div class="form-group">
                    <label for="inputListingReserve" class="col-lg-2 control-label">Reserve Price</label>
                    <div class="col-lg-5">
                        <input value="${listing.reserve}" type="text"
                            class="form-control" id="inputListingReserve"
                            placeholder="Reserve Price">
                    </div>
                </div>
				<div class="form-group">
                    <label for="inputListingPrice" class="col-lg-2 control-label">Start Price</label>
                    <div class="col-lg-5">
                        <input value="${listing.start}" type="text"
                            class="form-control" id="inputListingStart"
                            placeholder="Start Price">
                    </div>
                </div>
				<div class="form-group">
                    <label for="inputListingIncrement" class="col-lg-2 control-label">Bidding Increment</label>
                    <div class="col-lg-5">
                        <input value="${listing.increment}" type="text"
                            class="form-control" id="inputListingIncrement"
                            placeholder="Bidding Increment">
                    </div>
                </div>
				<div class="form-group">
                    <label for="inputListingCloseTime" class="col-lg-2 control-label">Close Time</label>
                    <div class="col-lg-5">
                        <input value="${listing.closeTime}" type="text"
                            class="form-control" id="inputListingCloseTime"
                            placeholder="Closing Time">
                    </div>
                </div>
			</fieldset>
		</form>
	</div>
</t:column1>