<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Cycling Serbia</title>

 <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
 <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
 <link href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>
</head>
<body>
	<%@include file="nav.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
			<div class="cover">
				<h1 class="text-center text-white">Welcome to Cycling Serbia</h1>
				<h3 class="text-center text-white">All tracks in Serbia on one place</h3>
				<form:form modelAttribute="mountain" action="mountain/show-for-" method="get" class="text-center" id="index-form" onchange="">
					<select id="index-from-button" name="region">
						<option value="all" class="select-option">Select Region</option>
						<c:forEach items="${regions}" var="region">
							<option value="${region.name}" class="select-option">${region.name}</option>
						</c:forEach>
	                    
	                   
					</select>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
					<input type="submit" class="submit-btn" value="Search"/>
				</form:form>
				
			</div>
		</div>
	</div>
	<section id="popular">
		<h1 class="text-center padding-2">Popular Destinations</h1>
		<div class="container">
			<div class="row">
			
				<c:forEach items="${mountains}" var="mountain">
					<div class="col-lg-4 col-md-4 col-sm-12">
						<div class="card h-100 ">
          					<a href="<c:url value='/mountain/show-mountain-${mountain.id }'/>"><img class="card-img-top" src="<c:url value='/admin/panel-show-photo-${mountain.id }'/>" alt=""></a>
          					<div class="card-body dark">
	            				<h4 class="card-title">
	              					<a href="<c:url value='/mountain/show-mountain-${mountain.id }'/>">${mountain.name }</a>
	           					</h4>
	            				<p class="card-text dark">${mountain.description }</p>
          					 </div>
        				 </div>
   					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<%@include file="footer.jsp" %>
	 
	<script type="text/javascript" src="<c:url value='static/js/main.js'/>"></script>
</body>
</html>