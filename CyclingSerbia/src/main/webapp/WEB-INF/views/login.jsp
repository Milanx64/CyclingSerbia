<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login page</title>
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    </head>
 
<body>
	<%@include file="nav.jsp" %>
	
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-12 col-md-12 col-sm-12"  style="margin-top:6em;">
				<h1 class="text-center">Login</h1>
			</div>
			
			 <c:url var="loginUrl" value="/login" />
			 
			 <div class="col-lg-6 col-md-6 col-sm-12">
			 	                        
             <form action="${loginUrl}" method="post" class="form-horizontal">
             	
                 <c:if test="${param.error != null}">
                     <div class="alert alert-danger col-lg-12 col-md-12 col-sm-12">
                         <p>Invalid username and password.</p>
                     </div>
                 </c:if>
                 <c:if test="${param.logout != null}">
                     <div class="alert alert-success col-lg-12 col-md-12 col-sm-12">
                         <p>You have been logged out successfully.</p>
                     </div>
                 </c:if>
                 <div class="input-group input-sm col-lg-12 col-md-12 col-sm-12">
                     <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                     <input type="email" class="form-control" id="username" name="email" placeholder="Enter Username" required>
                 </div>
                 <div class="input-group input-sm col-lg-12 col-md-12 col-sm-12">
                     <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                     <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                 </div>
                 <div class="input-group input-sm remember-me col-lg-12 col-md-12 col-sm-12">
                   <div class="checkbox">
                     <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                   </div>
                 </div>
                
                      <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                 <div class="form-actions col-lg-6 col-md-6 col-sm-12">
                     <input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
                 </div>
                 
             </form>
             </div>
             </div>
		</div>

         
        
 
</body>
</html>