<%-- 
    Document   : game
    Created on : Apr 29, 2025, 9:24:20 AM
    Author     : beu29
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Blackjack Game</title>
        <link rel="stylesheet" href="css/blackjack.css">
    </head>
    <body>
        <div class="container">
            <h1>Blackjack</h1>

            <c:set var="game" value="${sessionScope.blackjackGame}" />
            <c:if test="${empty game}">
                <c:redirect url="blackjack?action=newGame" />
            </c:if>

            <div class="status">
                ${game.statusMessage}
            </div>

            <div class="money">
                Your Money: <span>$${game.playerMoney}</span>
                <c:if test="${game.currentBet > 0}">
                    | Current Bet: <span>$${game.currentBet}</span>
                </c:if>
            </div>

            <div class="hand">
                <h2>Dealer's Hand (${game.playerTurn && game.dealerHand.size() > 0 ? game.dealerHand.cards[0].value : game.dealerHand.calculateValue()})</h2>
                <div class="cards">
                    <c:if test="${not empty game.dealerHand.cards}">
                        <c:forEach var="card" items="${game.dealerHand.cards}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.index == 1 && game.playerTurn}">
                                    <div class="card hidden">
                                        <div class="card-rank">?</div>
                                        <div class="card-symbol">?</div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="card ${card.red ? 'red' : ''}">
                                        <div class="card-rank">${card.rank}</div>
                                        <div class="card-symbol">${card.symbol}</div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>
                </div>
            </div>

            <div class="hand">
                <h2>Your Hand (${game.playerHand.calculateValue()})</h2>
                <div class="cards">
                    <c:forEach var="card" items="${game.playerHand.cards}">
                        <div class="card ${card.red ? 'red' : ''}">
                            <div class="card-rank">${card.rank}</div>
                            <div class="card-symbol">${card.symbol}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="controls">
                <c:choose>
                    <c:when test="${game.canBet()}">
                        <form action="blackjack" method="post">
                            <input type="hidden" name="action" value="placeBet">
                            <input type="number" class="bet-input" name="betAmount" min="1" max="${game.playerMoney}" value="10" required>
                            <button type="submit" class="btn">Place Bet</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="blackjack" method="post" style="display: inline-block;">
                            <input type="hidden" name="action" value="hit">
                            <button type="submit" class="btn" ${game.playerTurn ? '' : 'disabled'}>Hit</button>
                        </form>

                        <form action="blackjack" method="post" style="display: inline-block;">
                            <input type="hidden" name="action" value="stand">
                            <button type="submit" class="btn" ${game.playerTurn ? '' : 'disabled'}>Stand</button>
                        </form>
                    </c:otherwise>
                </c:choose>

                <form action="blackjack" method="post" style="display: inline-block;">
                    <input type="hidden" name="action" value="newGame">
                    <button type="submit" class="btn">New Game</button>
                </form>
            </div>

            <jsp:include page="rules.jspf" />
        </div>
    </body>
</html>