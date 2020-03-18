<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	
	<div class="well lead">User Registration Form</div>
        <form:form method="POST" modelAttribute="user" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">First name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="firstname" id="firstname" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="firstname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Last Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="lastname" id="lastname" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="lastname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     		 <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Age</label>
                    <div class="col-md-7">
                        <form:input type="text" path="age" id="age" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="age" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password</label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="email">Email</label>
                    <div class="col-md-7">
                    	<c:choose>
	                    	<c:when test="${edit}">
	                        	<form:input type="text" path="email" id="email" class="form-control input-sm" />
	                        </c:when>
	                        <c:otherwise>
								<form:input type="text" path="email" id="email" class="form-control input-sm" />        
	                        	<div class="has-error">
	    	                        <form:errors path="email" class="help-inline"/>
		                        </div>
	                        </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
                    <div class="col-md-7">
                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="userProfiles" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/registration' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/reqistration' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
</body>
</html>