<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${mountain.name }</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<%@include file="nav.jsp" %>
	<h1>${mountain.name }</h1>
	<h3>${mountain.description }</h3>
	<h4>${mountain.tracks }</h4>
	
	 <c:forEach items="${mountain.tracks}" var="track">
              ${track.id }
              ${track.description }
              ${track.cost }      
     </c:forEach>
</body>
</html>