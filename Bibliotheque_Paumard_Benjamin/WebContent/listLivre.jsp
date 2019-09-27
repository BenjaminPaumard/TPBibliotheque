<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>liste des livres</title>
	</head>
	<body>
		<table style="text-align: center;" class="table table-striped">
			<tr>
				<td scope="col">Titre du livre</td>
				<td scope="col">Auteur du livre</td>
				<td scope="col">action</td>
			</tr>
		
			<c:forEach items="${livres}" var="l">
				<tr>
					<td><c:out value="${l.titre}"/></td>
					<td><c:out value="${l.auteur}"/></td>
					<td>
						<c:if test="${!empty user}">
							<c:if test="${!empty admin}">
								<form method="post" action="RemoveLivre">
									<input type="hidden" name="id" value ="${l.id}">
									<input type="submit" value="supprimer le livre">
								</form>
							</c:if>
							<form method="post" action="EmpruntLivre">
								<input type="hidden" name="id" value ="${l.id}">
								<input type="hidden" name="username" value ="${user}">
								<input type="submit" value="Emprunter le livre">
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>