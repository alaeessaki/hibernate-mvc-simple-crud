<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	<form action="persons" method="POST">
		<fieldset>
			<legend>Infos field</legend>
			<label for="nom"></label>
			<input type="text" id="nom" name="nom" placeholder="nom">
			<label for="prenom"></label>
			<input type="text" id="prenom" name="prenom" placeholder="prenom">
			<label for="age"></label>
			<input type="number" id="age" name="age" placeholder="age">
			<button type="submit">add</button>
		</fieldset>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.id }</td>
				<td>${person.nom }</td>
				<td>${person.prenom }</td>
				<td>${person.age }</td>
				<td>
					<a href="updatePerson?id=${person.id}">update</a>
					<a href="deletePerson?id=${person.id }">delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>