<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="nav.jsp" %>
	<tbody>
		<table>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Type</td>
				<td>Description</td>
				<td>Content</td>
			</tr>
	     <c:forEach items="${photos}" var="doc" varStatus="counter">
	         <tr>
	             <td>${counter.index + 1}</td>
	             <td>${doc.name}</td>
	             <td>${doc.type}</td>
	             <td>${doc.description}</td>
	             <td><img src="<c:url value='/admin/panel-show-photo-${doc.id}'/>" height="250px" width="250px"/></td>
	             <sec:authorize access=" hasRole('ADMIN') or hasRole('DBA')">
	             	<td><a href='<c:url value="/admin/panel-delete-photo-${doc.id}" />'>Delete Photo</a></td>
	             </sec:authorize>
	         </tr>
	     </c:forEach>
	     </table>
     </tbody>
</body>
</html>