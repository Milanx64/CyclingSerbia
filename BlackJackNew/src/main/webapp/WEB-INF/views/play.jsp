<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr>
			<td>Name</td>
			<td>GameScore</td>
			<td>Current Score</td>
			<td>Game Score</td>
		</tr>
		
		<tr>
			<td>${game.player.name}</td>
			<td>${game.player.score}</td>
			<td>${game.player.currentScore}</td>
			<td>${game.player.playerGameScore}</td>
		</tr>
		<tr>
			<td>House Score</td>
			<td>Current House Score</td>
		</tr>
		
		<tr>
			<td>${game.house.houseScore}</td>
			<td>${game.house.currentHouseScore}</td>
			<td>DA li radi ${test}</td>
		</tr>
		
	</table>
	${game.player.name}
	${game.cards.cards} 
	<form:form method="POST"  action="/BlackJackNew/play">
		
		<input type="Submit" value = "pull">
	</form:form>
</body>
</html>