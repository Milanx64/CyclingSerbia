<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mountains List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
   
</head>
 
<body>
    <%@include file="nav.jsp" %>
      <div class="container padding-buttom-1" style="margin-top:5em">
      <h1 class="text-center padding-2">${msg }</h1>
		<div class="row justify-content-center">
			<div class="col-lg-12 col-md-12 col-sm-12 form-holder">
				<form:form modelAttribute="mountain" action="show-for-" method="get" class="text-center" id="index-form" onchange="">
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
			
			<c:forEach items="${mountains}" var="mountain">
				<div class="col-lg-4 col-md-4 col-sm-12 margin-top-4">
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
	<div class="margin-top-4">
    	<%@include file="footer.jsp" %>
     </div>
</body>
</html>