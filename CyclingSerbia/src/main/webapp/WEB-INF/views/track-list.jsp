<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<%@include file="nav.jsp" %>
	<div class="generic-container">
        
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Tracks </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Difficulty</th>
                        <th>Cost</th>
                        <th>Duration</th>
                        <th>Length</th>
                        <th>Mountain</th>
                        
                        
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${tracks}" var="track">
                    <tr>
                        <td>${track.name}</td>
                        <td>${track.description}</td>
                        <td>${track.difficulty}</td>
                        <td>${track.cost}</td>
                        <td>${track.duration}</td>
                        <td>${track.length}</td>
                        <td>${track.mountain.name}</td>
                        
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='/mountain/edit-track-${track.id}' />" class="btn btn-success custom-width">edit</a></td>
                        </sec:authorize>
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
                
            </div>
        </sec:authorize>
    </div>
</body>
</html>