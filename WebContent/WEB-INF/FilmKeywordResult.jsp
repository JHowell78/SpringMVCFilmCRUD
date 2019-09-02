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
<a href="index.html">Return to Main Menu</a> <br> <br> 


	<div class="container">

		<h2>Find film by keyword:</h2>

		<c:choose>

			<c:when test="${! empty filmByKeyword}">

				<c:forEach items="${filmByKeyword }" var="film">
				<br>
					<li>${film.title}</li>
					<li>ID: ${film.id}</li>
					<li>Synopsis: ${film.description}</li>
					<li>Rating: ${film.rating}</li>
					<li>Year Released: ${film.releasYear}</li>
					<li>Category: ${film.category}</li>
					<li>Language Id: ${film.languageId}</li>
					<li>Language: ${film.language}</li>
					<li>Rental Duration: ${film.rentalDuration}</li>
					<li>Rental Rate: ${film.rental_rate}</li>
					<li>Film Length: ${film.length}</li>
					<li>Rental Rate: ${film.rental_rate}</li>
					<li>Replacement Cost: ${film.replacement_cost}</li>
					<li>Special Features : ${film.specialFeatures}</li>
						<li>Cast: </li>
					<c:forEach var="cast" items="${film.actor}">
					<ul>
					<li>${cast}</li>
					</ul>
					</c:forEach>
				</c:forEach>
				<br> <br> 
			</c:when>

			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>
</body>
</html>
