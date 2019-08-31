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



	<div class="container">

		<h2>Find film by keyword:</h2>

		<c:choose>

			<c:when test="${! empty filmByKeyword}">

				<c:forEach items="${filmByKeyword }" var="film">
					<li>${film.title}</li>
					<li>ID: ${film.id}</li>
					<li>Synopsis: ${film.description}</li>
					<li>Cast:</li>
					


				</c:forEach>
			</c:when>

			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>
</body>
</html>
