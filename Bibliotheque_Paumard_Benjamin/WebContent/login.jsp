<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Connexion</title>
	</head>
	<body>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<div class="col-md-16" style="text-align: center;">
			<h2>Connexion</h2>
			<c:if test="${!empty erreur}">
				<c:out value="${erreur}"/>
			</c:if>
			<form method="post" action="Login">
				<div class="form-group">
					<label>Nom d'utilisateur : </label>
					<input name="username">
				</div>
				<div class="form-group">
					<label>Mot de passe : </label>
					<input type="password" name="password">
				</div>
				<input type="submit" class="btn btn-primary" value="Se connecter">
			</form>
		</div>
	</body>
</html>