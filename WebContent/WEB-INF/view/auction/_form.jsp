<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<input name="id" value=${auction.id } type="hidden" />

<div class="form-group">
	<label for="inputListingTitle" class="col-lg-2 control-label">Title
		<span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<input name="title" value="${auction.title}" type="text"
			class="form-control" id="inputListingTitle" placeholder="Title">
		<p class="help-block">10 word limit.</p>
	</div>
</div>
<div class="form-group">
	<label for="inputListingCategory" class="col-lg-2 control-label">Category
		<span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<select name="category" id="inputListingCategory"
			value="${auction.category}" class="form-control" id="select">
			<option value="">Select Category</option>
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label for="inputListingPicture" class="col-lg-2 control-label">Add
		Photo</label>
	<div class="col-lg-5">
		<input name="image" type="file" id="inputListingPicture">
		<p class="help-block">Select an image to accompany your auction.</p>
	</div>
</div>
<div class="form-group">
	<label for="inputListingDescription" class="col-lg-2 control-label">Description
		<span style="color: red">*</span>
	</label>
	<div class="col-lg-10">
		<textarea name="description" class="form-control" rows="3"
			id="textArea">${auction.description }</textarea>
		<span class="help-block">100 word limit.</span>
	</div>
</div>
<div class="form-group">
	<label for="inputListingPostage" class="col-lg-2 control-label">Postage
		Details <span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<input name="postagedetails" value="${auction.postageDetails}"
			type="text" class="form-control" id="inputListingPostage"
			placeholder="Postage">
	</div>
</div>
<div class="form-group">
	<label for="inputListingReserve" class="col-lg-2 control-label">Reserve
		Price <span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<input name="reservePrice" value="${auction.reservePrice}" type="text"
			class="form-control" id="inputListingReserve"
			placeholder="Reserve Price">
	</div>
</div>
<div class="form-group">
	<label for="inputListingPrice" class="col-lg-2 control-label">Start
		Price <span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<input name="startPrice" value="${auction.currentPrice}" type="text"
			class="form-control" id="inputListingStart" placeholder="Start Price">
	</div>
</div>
<div class="form-group">
	<label for="inputListingIncrement" class="col-lg-2 control-label">Bidding
		Increment <span style="color: red">*</span>
	</label>
	<div class="col-lg-5">
		<input name="increment" value="${auction.increment}" type="text"
			class="form-control" id="inputListingIncrement"
			placeholder="Bidding Increment">
	</div>
</div>
<div class="form-group">
	<label for="inputListingCloseTime" class="col-lg-2 control-label">Auction
		Length</label>
	<div class="col-lg-5">
		<input name="exptime" id="inputListingCloseTime" type="text"
			class="slider span2" value="" data-slider-min="3"
			data-slider-max="60" data-slider-step="1" data-slider-value="10"
			data-slider-orientation="horizontal" data-slider-selection="after"
			data-slider-tooltip="show"> <span class="help-block">Length
			in minutes.</span>
	</div>
</div>
<div class="form-group">
	<div class="col-lg-10 col-lg-offset-2">
		<button class="btn btn-default">Cancel</button>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</div>