
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin panel</title>

<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<h1>Welcome admin ${loggedinuser}</h1>
	
	<div class="container">
		<div class="row">
			<div class="admin-panel">
				<a href="<c:url value='/admin/panel-create-new' />" class="btn btn-primary">create new admin</a>
				<a href="<c:url value='/admin/panel-edit-admin-${user.id}' />" class="btn btn-primary">edit admin</a>
				<a href="<c:url value='/admin/panel-add-photo' />" class="btn btn-primary">upload  photo</a>
				<a href="<c:url value='/admin/panel-show-all-photos' />" class="btn btn-primary">Show all photos</a>
				<a href="<c:url value='/admin/panel-list-all-users' />" class="btn btn-primary">show all users</a>
				<a href="<c:url value='/mountain/new-mountain' />" class="btn btn-primary">create new mountain</a>
				<a href="<c:url value='/mountain/show-all-mountains' />" class="btn btn-primary">Show all mountains</a>
			</div>
		</div>
	</div>
</body>
</html>