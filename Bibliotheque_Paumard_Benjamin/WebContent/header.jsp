<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<body>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<header>
			<nav class="navbar" style="background-color: rgba(0,123,255,.25);">
				<a href="index.jsp">Acceuil</a>
				<c:if test="${empty user}">
					<a href="Login">Se connecter</a>		
				</c:if>
				<c:if test="${!empty user}">
					<c:if test="${!empty admin}">
						<a href="AddLivre">Ajouter un livre</a>
					</c:if>
					<a href="ListLivre">Liste des livres disponibles</a>
					<form method="post" action="ListLivreUser"></form>
					<a href="ListLivreUser?username=${user}">Liste des livres de l'utilisateur</a>
					<a href="Logout">Se déconnecter</a>
				</c:if>
			</nav>
		</header>
	</body>
</html>