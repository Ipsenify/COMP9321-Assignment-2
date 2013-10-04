<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<input type="hidden" value="${synchronizer}" name="synchronizer"/>

<div class="form-group">
	<label for="inputFirstName" class="col-lg-2 control-label">Name</label>
	<div class="col-lg-5">
		<input name="firstName" value="${user.firstName}" type="text" class="form-control"
			id="inputFirstName" placeholder="First Name">
	</div>
	<div class="col-lg-5">
		<input name="lastName" value="${user.lastName}" type="text" class="form-control"
			id="inputLastName" placeholder="Last Name">
	</div>
</div>

<div class="form-group">
	<label for="inputNickname" class="col-lg-2 control-label">Nickname</label>
	<div class="col-lg-10">
		<input name="nickName" value="${user.nickName}" type="text" class="form-control" id="inputNickname"
			placeholder="Nickname">
	</div>
</div>

<div class="form-group">
	<label for="inputEmail" class="col-lg-2 control-label">Email <span style="color:red">*</span></label>
	<div class="col-lg-10">
		<input name="email" value="${user.email}" type="text" class="form-control" id="inputEmail"
			placeholder="Email">
	</div>
</div>

<div class="form-group">
	<label for="inputUsername" class="col-lg-2 control-label">Username <span style="color:red">*</span></label>
	<div class="col-lg-10">
		<input name="userName" value="${user.userName}" type="text" class="form-control" id="inputUsername"
			placeholder="Username" <c:if test="${user.getId() != null}" >disabled</c:if>>
			<span id="usernamespan"></span>
	</div>
</div>

<c:if test="${user.getId() == null}" >
<div class="form-group">
	<label for="inputPassword" class="col-lg-2 control-label">Password <span style="color:red">*</span></label>
	<div class="col-lg-10">
		<input  name="password" type="password" class="form-control" id="inputPassword"
			placeholder="Password">
	</div>
</div>

<div class="form-group">
	<label for="inputConfirmPassword" class="col-lg-2 control-label">Confirm Password <span style="color:red">*</span></label>
	<div class="col-lg-10">
		<input name="confirmPassword" type="password" class="form-control" id="inputConfirmPassword"
			placeholder="Confirm Password">
			<span class="help-inline" id="confirmpasswordspan"></span>
	</div>
</div>
</c:if>

<div class="form-group">
	<label for="textArea" class="col-lg-2 control-label">Address</label>
	<div class="col-lg-10">
		<textarea name="fullAddress" class="form-control" rows="3" id="fullAddress">${user.fullAddress}</textarea>
		<span class="help-block">Your Full Address</span>
	</div>
</div>
<div class="form-group">
	<label for="select" class="col-lg-2 control-label">Birth Year</label>
	<div class="col-lg-10">
		<select name="yearOfBirth" class="form-control" id="select">
			<option value="0">Select Birth Year</option>
			<c:forEach begin="1900" end="2013" varStatus="loop">
				<c:set var="currentYear" value="${loop.index}" />
				<option <c:if test="${currentYear == user.yearOfBirth}">selected</c:if> value="${currentYear}">${currentYear}</option>
			</c:forEach>
		</select>
	</div>
</div>
<div class="form-group">
	<label for="inputCreditCard" class="col-lg-2 control-label">Credit
		Card</label>
	<div class="col-lg-5">
		<input name="creditCardNumber" type="text" class="form-control" id="inputCreditCard"
			placeholder="**** **** **** ${user.getShortenedCreditCard()}">
	</div>
</div>
<div class="form-group">
	<div class="col-lg-10 col-lg-offset-2">
		<c:if test="${user.getId() == null}" >
			<a href="<t:url />/home" class="btn btn-default">Cancel</a>
		</c:if>
		<c:if test="${user.getId() != null}" >
			<a href="<t:url />/user/view" class="btn btn-default">Cancel</a>
		</c:if>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</div>