<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By ID</title>
</head>
<body>
	<a href="index.html">Return to Main Menu</a>
	<br>
	<br>
	<h2>Find film by ID results:</h2>
	<c:choose>
		<c:when test="${! empty filmById}">
			<ul>
				<li>${filmById}</li>
			</ul>
			<br>
		</c:when>


		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<a href="addFilm.html">Add New Film</a>
	<br />
	</h3>
	<h4>
		<br> <a href="modFilm.html">Modify or Update a Film you added</a> <br>
		<br>
		<a href="deleteFilm.html">Delect a Film you added</a> <br>
	</h4>
</body>
</html>

