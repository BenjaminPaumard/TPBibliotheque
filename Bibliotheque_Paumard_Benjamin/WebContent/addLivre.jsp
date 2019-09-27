<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ajout d'un livre</title>
	</head>
	<body>
		<div class="col-md-16" style="text-align: center;">
			<h2>Ajout d'un livre</h2>
			<form method="post" action="AddLivre">
				<div class="form-group">
					<label>Titre du livre : </label>
					<input name="titre">
				</div>
				
				<div class="form-group">
					<label>Auteur du livre :</label>
					<input name="auteur">
				</div>
				<input type="submit" class="btn btn-primary" value="Ajouter"> 
			</form>
		</div>
	</body>
</html>