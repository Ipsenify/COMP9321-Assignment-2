<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:column1>
	<jsp:attribute name="javascript">
		<script type="text/javascript">
			$(document).ready(
					function() {
						$("#form").validate(
								{
									rules : {
										currentpassword: {
											required: true,
										}, 
										newpassword : {
											minlength : 6,
											required : true
										},
										confirmPassword : {
											minlength : 6,
											required : true,
											equalTo : "#inputPassword"
										},
									},
									highlight : function(element) {
										$(element).closest('.form-group')
												.addClass('has-error');
									},
									unhighlight : function(element) {
										$(element).closest('.form-group')
												.removeClass('has-error');
									},
									messages : {

									}
								});
					});
		</script>
	</jsp:attribute>
	<jsp:body>
		
		<div class="well">

		<t:alerts />
		
		<form id="form" class="form-horizontal" method="POST">
			<fieldset>
				<legend>Change Password</legend>
				
<input type="hidden" value="${synchronizer}" name="synchronizer" />

<div class="form-group">
	<label for="inputCurrentPassword" class="col-lg-2 control-label">Current Password <span
							style="color: red">*</span></label>
	<div class="col-lg-10">
		<input name="currentpassword" type="password" class="form-control"
								id="inputCurrentPassword" placeholder="Password">
	</div>
</div>

<div class="form-group">
	<label for="inputPassword" class="col-lg-2 control-label">New Password <span
							style="color: red">*</span></label>
	<div class="col-lg-10">
		<input name="newpassword" type="password" class="form-control"
								id="inputPassword" placeholder="Password">
	</div>
</div>

<div class="form-group">
	<label for="inputConfirmPassword" class="col-lg-2 control-label">Confirm New Password <span
							style="color: red">*</span></label>
	<div class="col-lg-10">
		<input name="confirmPassword" type="password" class="form-control"
								id="inputConfirmPassword" placeholder="Confirm Password">
			<span class="help-inline" id="confirmpasswordspan"></span>
	</div>
</div>

<div class="form-group">
	<div class="col-lg-10 col-lg-offset-2">
		<a href="<t:url />/user/view" class="btn btn-default">Cancel</a>
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</div>
			</fieldset>
		</form>
	</div>
	</jsp:body>
</t:column1>