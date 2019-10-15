<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	             <td><img src="${doc.base64Encoded}"></td>
	         </tr>
	     </c:forEach>
	     </table>
     </tbody>
</body>
</html>