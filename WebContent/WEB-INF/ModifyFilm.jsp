<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update/DeleteFilm</title>
</head>
<body>
    <a href="index.html">Return to Main Menu</a>
    <h3>Update Film</h3>
    <form:form action="editedFilm.do" method="PUT" modelAttribute="film">
        <input type="hidden" name="id" value="${film.id}" />
        Title: <input type="text" name="title" value="${film.title}" />
        <br> 
        Description: <input type="text" name="description"
            value="${film.description}" />
        <br> 
        Release Year: <input type="number" min="1900" name="releasYear"
            value="${film.releasYear}" />
        <br> 
        
        <br>
        Language: <select name="languageId">
            <c:if test="${film.language.equals('English')}">
                <option value="1" selected>English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </c:if>
            <c:if test="${film.language.equals('Italian')}">
                <option value="1">English</option>
                <option value="2" selected>Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </c:if>
            <c:if test="${film.language.equals('Japanese')}">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3" selected>Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </c:if>
            <c:if test="${film.language.equals('Mandarin')}">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4" selected>Mandarin</option>
                <option value="5">French</option>
                <option value="6">German</option>
            </c:if>
            <c:if test="${film.language.equals('French')}">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5" selected>French</option>
                <option value="6">German</option>
            </c:if>
            <c:if test="${film.language.equals('German')}">
                <option value="1">English</option>
                <option value="2">Italian</option>
                <option value="3">Japanese</option>
                <option value="4">Mandarin</option>
                <option value="5">French</option>
                <option value="6" selected>German</option>
            </c:if>
        </select>
        <br>
        Rental Duration: <input type="number" min="1" name="rentalDuration"
            value="${film.rentalDuration}" />
        <br>
        Rental Rate: <input type="number" min="0.00" step="0.01"
            name="rental_rate" value="${film.rental_rate}" />
        <br>
        Length: <input type="number" min="1" name="length"
            value="${film.length}" />
        <br> 
        Replacement Cost: <input type="number" min="0.01" step="0.01"
            name="replacement_cost" value="${film.replacement_cost}" />
        <br>
        Rating: <select name="rating">
            <c:if test="${film.rating.equals('G')}">
                <option value="G" selected>G</option>
                <option value="PG">PG</option>
                <option value="PG13">PG-13</option>
                <option value="R">R</option>
                <option value="NC17">NC-17</option>
            </c:if>
            <c:if test="${film.rating.equals('PG')}">
                <option value="G">G</option>
                <option value="PG" selected>PG</option>
                <option value="PG13">PG-13</option>
                <option value="R">R</option>
                <option value="NC17">NC-17</option>
            </c:if>
            <c:if test="${film.rating.equals('PG13')}">
                <option value="G">G</option>
                <option value="PG">PG</option>
                <option value="PG13" selected>PG-13</option>
                <option value="R">R</option>
                <option value="NC17">NC-17</option>
            </c:if>
            <c:if test="${film.rating.equals('R')}">
                <option value="G">G</option>
                <option value="PG">PG</option>
                <option value="PG13">PG-13</option>
                <option value="R" selected>R</option>
                <option value="NC17">NC-17</option>
            </c:if>
            <c:if test="${film.rating.equals('NC17')}">
                <option value="G">G</option>
                <option value="PG">PG</option>
                <option value="PG13">PG-13</option>
                <option value="R">R</option>
                <option value="NC17" selected>NC-17</option>
            </c:if>
        </select>
        <br> 
        Special Features: <br>
        <c:if test="${film.specialFeatures.contains('Trailers')}">
            <input type="checkbox" name="specialFeatures" value="Trailers"
                checked="checked"> Trailers <br>
        </c:if>
        <c:if test="${not film.specialFeatures.contains('Trailers')}">
            <input type="checkbox" name="specialFeatures" value="Trailers"> Trailers <br>
        </c:if>
        <c:if test="${film.specialFeatures.contains('Commentaries')}">
            <input type="checkbox" name="specialFeatures" value="Commentaries"
                checked="checked"> Commentaries <br>
        </c:if>
        <c:if test="${not film.specialFeatures.contains('Commentaries')}">
            <input type="checkbox" name="specialFeatures" value="Commentaries"> Commentaries <br>
        </c:if>
        <c:if test="${film.specialFeatures.contains('Deleted Scenes')}">
            <input type="checkbox" name="specialFeatures" value="Deleted Scenes"
                checked="checked"> Deleted Scenes <br>
        </c:if>
        <c:if test="${not film.specialFeatures.contains('Deleted Scenes')}">
            <input type="checkbox" name="specialFeatures" value="Deleted Scenes"> Deleted Scenes <br>
        </c:if>
        <c:if test="${film.specialFeatures.contains('Behind the Scenes')}">
            <input type="checkbox" name="specialFeatures"
                value="Behind the Scenes" checked="checked"> Behind the Scenes <br>
        </c:if>
        <c:if test="${not film.specialFeatures.contains('Behind the Scenes')}">
            <input type="checkbox" name="specialFeatures"
                value="Behind the Scenes"> Behind the Scenes <br>
        </c:if>
        <input type="submit" name="Add New Film" value="Edit" />
    </form:form>
    <form:form action="deleteFilm.do" method="POST" modelAttribute="film">
        <input type="hidden" name="id" value="${film.id}" />
        <input type="submit" name="Delete this Film"
            value="Delete from Inventory" />
    </form:form>
    
    
</body>
</html>