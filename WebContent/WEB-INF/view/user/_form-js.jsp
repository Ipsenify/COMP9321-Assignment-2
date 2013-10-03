<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<script type="text/javascript">
	$(document).ready(function() {
		$("#form").validate({
			rules : {
				firstName : {
					minlength : 1,
					required : false
				},
				lastName : {
					minlength : 1,
					required : false
				},
				email : {
					required : true,
					email : true
				},
				password : {
					minlength : 6,
					required : true
				},
				confirmPassword : {
					minlength : 6,
					required : true,
					equalTo : "#inputPassword"
				},
				userName : {
					minlength : 6,
					required : true
				}
			/*
			userName : {
				required : true,
				remote : {
					url : "<t:url />/user/validateusername",
					type : "post",
					data : {
						username : function() {
							return $("#inputUsername").val();
						}
					}
				}
			}*/
			},
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).closest('.form-group').removeClass('has-error');
			},
			messages : {

			}
		});
	});

	$("#inputUsername")
			.blur(
					function() {
						var username = $("#inputUsername").val();
						var request = $.ajax({
							url : "<t:url />/user/validateusername",
							type : "POST",
							data : {
								username : username
							},
							dataType : "json"
						});
						request
								.done(function(json) {
									if (json.result == "false") {
										$("#inputUsername").parent()
												.removeClass("has-error");
										$("#usernamespan").html('');
									} else {
										$("#inputUsername").parent().addClass(
												"has-error");
										$("#usernamespan")
												.html(
														'<label for="inputUsername" class="error">This username has already been taken. Try another!</label>');
									}
								});
					});
</script>
