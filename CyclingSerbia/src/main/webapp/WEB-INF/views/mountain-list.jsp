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
        
        <div class="panel panel-default center">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Mountains</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${mountains}" var="mountain">
                    <tr>
                        <td> <a href="<c:url value='/mountain/show-mountain-${mountain.id}' />">${mountain.name}</a></td>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='/admin/panel-add-photo-${mountain.id}' />" class="btn btn-success custom-width">Add Photo</a></td>
                        </sec:authorize>
                        
                        
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='/mountain/edit-mountain-${mountain.id}' />" class="btn btn-success custom-width">Edit</a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                            <td><a href="<c:url value='/mountain/add-track-${mountain.id}' />" class="btn btn-success custom-width">Add Track</a></td>
                        </sec:authorize>
                        
                        	<td><a href="<c:url value='/mountain/show-all-tracks' />" class="btn btn-success custom-width">Show Tracks</a></td>
                        
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='/mountain/delete-mountain-${mountain.id}' />" class="btn btn-danger custom-width">delete</a></td>
                        </sec:authorize>
                        
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
                <a href="<c:url value='/mountain/new-mountain' />">Add New Mountain</a>
            </div>
        </sec:authorize>
    </div>
</body>
</html>