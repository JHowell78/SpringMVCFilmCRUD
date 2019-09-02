<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilmAdded</title>
</head>
<body>
	<a href="index.html">Home</a>
    <h2>Your Film Added</h2>
    <c:choose>
        <c:when test="${! empty filmAdd}">
            <ul>
                <li>${filmAdd}</li>
            </ul>
        </c:when>
        <c:otherwise>
            <p>Film Not Added</p>
        </c:otherwise>
    </c:choose>
</body>
</html>