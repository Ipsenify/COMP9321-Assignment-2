<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="pageTitle" scope="request" value="iBuy - ${auction.name}"/>

<t:column1>
    <div class="well">
        <h2>${listingBean.title}Title</h2>
        
        <div class="row">
            <div class="col-lg-6">
                <!-- Left Col -->
                <img src="${pageContext.request.contextPath}/theme/img/Capture.png" class="img-rounded" width="500" height="500">
                
            </div>
            <div class="col-lg-6">
                <!--  Right Col -->
                Category: ${listingBean.category}Cat<br/>
                Postage Details: ${listingBean.postage}post<br/>
                Starting/Current Bid: ${listingBean.start}start<br/>
                Time Left: ${listingBean.closeTime}close<br/>
            </div>
        </div>
        Description: ${listingBean.description}I eat poop
    </div>
</t:column1>