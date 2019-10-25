<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Track</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
      <%@include file="nav.jsp" %>
    <div class="generic-container">
      
 
        <div class="well lead">Track Registration Form</div>
        <form:form method="POST" modelAttribute="track" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="description">Description</label>
                    <div class="col-md-7">
                        <form:input type="text" path="description" id="description" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="description" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
          
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="difficulty">Difficulty</label>
                    <div class="col-md-7">
                        <form:input type="text" path="difficulty" id="difficulty" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="difficulty" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="cost">Cost</label>
                    <div class="col-md-7">
                        <form:input type="text" path="cost" id="cost" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="cost" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     		
     		<div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="duration">Duration</label>
                    <div class="col-md-7">
                        <form:input type="text" path="duration" id="duration" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="duration" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
          	<div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="length">length</label>
                    <div class="col-md-7">
                        <form:input type="text" path="length" id="length" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="length" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     		<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
</body>
</html>