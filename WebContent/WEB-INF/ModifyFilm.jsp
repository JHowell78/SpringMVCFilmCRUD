<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpdateFilm</title>
</head>
<body>
	<h2>Your Film Added</h2>
	<c:choose>
		<c:when test="${! empty filmEdit}">
			<ul>
				<li>${filmEdit}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Film Not Added</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
