<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:column1>
<div class="well">
<form class="form-horizontal">
      <fieldset>
        <legend>Join iBuy Today.</legend>
        
        <div class="form-group">
          <label for="inputFirstName" class="col-lg-2 control-label">Name</label>
          <div class="col-lg-5">
            <input value="${user.firstName}" type="text" class="form-control" id="inputFirstName" placeholder="First Name">
          </div>
          <div class="col-lg-5">
            <input value="${user.lastName}" type="text" class="form-control" id="inputLastName" placeholder="Last Name">
          </div>
        </div>
        <div class="form-group">
          <label for="inputEmail" class="col-lg-2 control-label">Email</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="inputEmail" placeholder="Email">
          </div>
        </div>
        
        <div class="form-group">
          <label for="inputUsername" class="col-lg-2 control-label">Username</label>
          <div class="col-lg-10">
            <input type="text" class="form-control" id="inputUsername" placeholder="Username">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword" class="col-lg-2 control-label">Password</label>
          <div class="col-lg-10">
            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
          </div>
        </div>
        
        <div class="form-group">
          <label for="textArea" class="col-lg-2 control-label">Address</label>
          <div class="col-lg-10">
            <textarea class="form-control" rows="3" id="textArea"></textarea>
            <span class="help-block">Your Full Address</span>
          </div>
        </div>
        <div class="form-group">
          <label for="select" class="col-lg-2 control-label">Birth Year</label>
          <div class="col-lg-10">
            <select class="form-control" id="select">
            	<option>Select Birth Year</option>
            	<c:forEach begin="1900" end="2013" varStatus="loop">
		        <c:set var="currentYear" value="${loop.index}" />
		        <option value="${currentYear}">${currentYear}</option>
		    </c:forEach>
             </select>
           </div>
         </div>
         <div class="form-group">
           <label for="inputCreditCard" class="col-lg-2 control-label">Credit Card</label>
           <div class="col-lg-5">
             <input type="text" class="form-control" id="inputCreditCard" placeholder="****">
           </div>
         </div>
         <div class="form-group">
           <div class="col-lg-10 col-lg-offset-2">
             <button class="btn btn-default">Cancel</button> 
             <button type="submit" class="btn btn-primary">Submit</button> 
           </div>
         </div>
       </fieldset>
     </form>
</div>
 </form>
</t:column1>