<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="pageTitle" scope="request" value="iBuy - ${auction.title}"/>

<t:column1>
    <div class="well">
        <h2>${auction.title}</h2>
        
        <div class="row">
            <div class="col-lg-6">
                <img src="${pageContext.request.contextPath}/theme/img/Capture.png" class="img-rounded" height="600">
                
            </div>
            <div class="col-lg-6">
                Category: ${auction.category}Cat<br/>
                Postage Details: ${auction.postageDetails}post<br/>
                Starting/Current Bid: ${auction.reservePrice}start<br/>
                Time Left: ${auction.title}close<br/>
            </div>
        </div>
        Description: ${auction.description}I eat poop 
    </div>
</t:column1>