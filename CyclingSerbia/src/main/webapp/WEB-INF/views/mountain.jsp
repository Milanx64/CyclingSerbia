<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${mountain.name }</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<%@include file="nav.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
			
			<div id="demo" class="carousel slide" data-ride="carousel">
				<h1 class="center text-serbia" id="mt">${mountain.name }</h1>
					  <!-- Indicators -->
					  <ul class="carousel-indicators">
					    <li data-target="#demo" data-slide-to="0" class="active"></li>
					    <li data-target="#demo" data-slide-to="1"></li>
					    <li data-target="#demo" data-slide-to="2"></li>
					  </ul>
			    		
						  <!-- The slideshow -->
						<div class="carousel-inner">
						    <c:forEach items="${photos}" var="photo">
							<div class="carousel-item active">
						      <img src="<c:url value='/admin/panel-show-photo-${photo.id}' />" alt="Los Angeles">
						    </div>
						    <div class="carousel-item">
						       <img src="<c:url value='/admin/panel-show-photo-${photo.id}' />" alt="Los Angeles">
						    </div>
						    <div class="carousel-item">
						       <img src="<c:url value='/admin/panel-show-photo-${photo.id}' />" alt="Los Angeles">
						    </div>
					</c:forEach>
					  </div>
					
					  <!-- Left and right controls -->
					  <a class="carousel-control-prev" href="#demo" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#demo" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
					
					</div>
				
				<div class="about-mt">
					<p class="mt-about-text">${mountain.description }<p>		
				</div>
				
				<div class="generic-container">
					<div class="panel panel-default">
			              <!-- Default panel contents -->
			            <div class="panel-heading center"><span class="lead">List of Tracks </span></div>
			            <table class="table table-hover">
			                <thead>
			                    <tr>
			                        <th>Name</th>
			                        <th>Description</th>
			                        <th>Difficulty</th>
			                        <th>Cost</th>
			                        <th>Duration</th>
			                        <th>Length</th>
			                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
			                            <th width="100"></th>
			                        </sec:authorize>
			                       
			                         
			                    </tr>
			                </thead>
			                <tbody>
			                <c:forEach items="${mountain.tracks}" var="track">
			                    <tr>
			                        <td>${track.name}</td>
			                        <td>${track.description}</td>
			                        <td>${track.difficulty}</td>
			                        <td>${track.cost}</td>
			                        <td>${track.duration}</td>
			                        <td>${track.length}</td>
			                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA') or hasRole('USER')">
			                            <td><a href="<c:url value='/mountain/edit-track-${track.id}' />" class="btn btn-success custom-width">Regist</a></td>
			                        </sec:authorize>
			                    </tr>
			                </c:forEach>
			                </tbody>
			            </table>
			        </div>
		        </div>		
			</div>
			
		</div>
	</div>
</body>
</html>