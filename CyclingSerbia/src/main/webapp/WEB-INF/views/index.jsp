<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cycling Serbia Home</title>
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
<body>
	<div class="container-fluid">
		<%@include file="nav.jsp" %>
		<div class="row">
			<div class="col-sm-12">
				
				
				<div id="demo" class="carousel slide" data-ride="carousel">

					  <!-- Indicators -->
					  <ul class="carousel-indicators">
					    <li data-target="#demo" data-slide-to="0" class="active"></li>
					    <li data-target="#demo" data-slide-to="1"></li>
					    <li data-target="#demo" data-slide-to="2"></li>
					  </ul>
					  
						  <!-- The slideshow -->
						<div class="carousel-inner">
						    <div class="carousel-item active">
						      <img src="<c:url value='/static/photos/mtb2.jpg' />" alt="Los Angeles">
						    </div>
						    <div class="carousel-item">
						       <img src="<c:url value='/static/photos/mtb3.jpg' />" alt="Los Angeles">
						    </div>
						    <div class="carousel-item">
						       <img src="<c:url value='/static/photos/planina.jpg' />" alt="Los Angeles">
						    </div>
					  </div>
					
					  <!-- Left and right controls -->
					  <a class="carousel-control-prev" href="#demo" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#demo" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
					
					</div>
					<h1 class="center text-serbia">Cycling Serbia</h1>
					
					<div class="about">
						<p class="about-text">Lorem ipsum dolor sit amet 
						consectetur adipisicing elit. Cupiditate sequi ea
						 vero tempora earum magni nesciunt, consectetur neque
						  corrupti at itaque. Provident distinctio hic 
						  , voluptatem at iste velit neque eum!</p>
					</div>
					<hr>
					<h3 class="center text-serbia" id="destination-text">Places to see</h3>
					<div class="to-see">
						<c:forEach items="${photos}" var="photo">
							<div class="img-holder">
							 	<img alt="not found" src="<c:url value='/admin/panel-show-photo-${photo.id}' />" class="img">
							</div>
						</c:forEach>
					</div>
			</div>
		</div>
		
	</div>
	<a href="<c:url value='/admin/panel' />">Admin</a>
</body>
</html>