<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<script type="text/javascript">
	$.validator.addMethod('positiveNumber', function(value) {
		return Number(value) > 0;
	}, 'Enter a non-negative number.');

	$.validator.addMethod('positiveInteger', function(value) {
		return Number(value) >= 0;
	}, 'Enter a non-negative number.');

	
	$(document).ready(function() {
		$("#form").validate({
			rules : {
				title : {
					maxlength : 60,
					required : true
				},
				category : {
					required : true
				},
				description : {
					maxlength : 600,
					required : true,
				},
				postagedetails : {
					required : true
				},
				reservePrice : {
					required : true,
					number : true, 
					positiveNumber: true
				},
				startPrice : {
					required : true,
					number : true, 
					positiveInteger: true
				},
				increment : {
					required : true,
					number : true, 
					positiveNumber: true
				},
				exptime : {
					required : false,
					number : true
				},
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
	
	$('.slider').slider()
</script>
