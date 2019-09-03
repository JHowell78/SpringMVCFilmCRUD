<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<a href="index.html">Return to Main Menu</a>
	<br>
	<br>
	<h2>Find film by ID results:</h2>
	<c:choose>
		<c:when test="${! empty filmById}">
			<!-- here -->
			<li>Title: ${filmById.title}</li>
			<li>ID: ${filmById.id}</li>
			<li>Synopsis: ${filmById.description}</li>
			<li>Rating: ${filmById.rating}</li>
			<li>Year Released: ${filmById.releasYear}</li>
			<li>Category: ${filmById.category}</li>
			<li>Language Id: ${filmById.languageId}</li>
			<li>Language: ${filmById.language}</li>
			<li>Rental Duration: ${filmById.rentalDuration}</li>
			<li>Rental Rate: ${filmById.rental_rate}</li>
			<li>Film Length: ${filmById.length}</li>
			<li>Rental Rate: ${filmById.rental_rate}</li>
			<li>Replacement Cost: ${filmById.replacement_cost}</li>
			<li>Special Features : ${filmById.specialFeatures}</li>
			<li>Cast:</li>
			<c:forEach var="cast" items="${filmById.actor}">
				<ul>
					<li>${cast}</li>
				</ul>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
	<form action="UPDATEFILM.do" method="GET">
		<button type="submit">Update/Delete Film</button>
		<br>
		<input type="hidden" name="id" value="${filmById.id}" />
	</form>
</body>
</html>

