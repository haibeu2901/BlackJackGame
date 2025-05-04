<%-- 
    Document   : game
    Created on : Apr 29, 2025, 9:24:20 AM
    Author     : beu29
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blackjack Game</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Blackjack</h1>

            <c:set var="game" value="${sessionScope.bjgame}" />
            <c:if test="${empty game}">
                <c:redirect url="GameControl?action=newGame" />
            </c:if>

            <div class="status">
                ${game.statusMessage}
            </div>

            <%@include file="rules.jspf" %>
        </div>
    </body>
</html>
