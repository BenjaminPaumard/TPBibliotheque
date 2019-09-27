<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>liste des livres de l'utilisateur</title>
	</head>
	<body>
		<c:if test="${!empty livres}">
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
								<form method="post" action="RendreLivre">
									<input type="hidden" name="id" value ="${l.id}">
									<input type="submit" value="Rendre le livre">
								</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${!empty livres}">
			L'utilisateur n'a pas emprunter de livre
		</c:if>
	</body>
</html>