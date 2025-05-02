/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author beu29
 */
public class BlackJackGame implements Serializable {

    // for serialize and de-seriablize
    private static final long serialVersionUID = 1L;

    public enum GameStatus {
        BETTING("Place your bet"),
        PLAYER_TURN("Your turn"),
        DEALER_TURN("Dealer's turn"),
        PLAYER_BLACKJACK("Blackjack !!! You win"),
        DEALER_BLACKJACK("Dealer has Blackjack !!! You lose"),
        BOTH_BLACKJACK("Both have Blackjack !!! Push"),
        PLAYER_BUST("Busted !!! You lose"),
        DEALER_BUST("Dealer busted !!! You win"),
        PLAYER_WIN("You win"),
        DEALER_WIN("Dealer wins"),
        PUSH("Push");

        private final String message;

        private GameStatus(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private int playerMoney;
    private int currentBet;
    private GameStatus gameStatus;

    public Deck getDeck() {
        return deck;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public String getStatusMessage() {
        return gameStatus.getMessage();
    }

    public boolean isPlayerTurn() {
        return (gameStatus == GameStatus.PLAYER_TURN);
    }

    public boolean canBet() {
        return gameStatus == GameStatus.BETTING
                || gameStatus == GameStatus.PLAYER_BLACKJACK
                || gameStatus == GameStatus.DEALER_BLACKJACK
                || gameStatus == GameStatus.PLAYER_BUST
                || gameStatus == GameStatus.DEALER_BUST
                || gameStatus == GameStatus.PLAYER_WIN
                || gameStatus == GameStatus.DEALER_WIN
                || gameStatus == GameStatus.PUSH
                || gameStatus == GameStatus.BOTH_BLACKJACK;
    }

    public BlackJackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        playerMoney = 10000;
        currentBet = 0;
        gameStatus = GameStatus.BETTING;
    }

    public BlackJackGame(Deck deck, Hand playerHand, Hand dealerHand, int playerMoney, int currentBet, GameStatus gameStatus) {
        this.deck = deck;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.playerMoney = playerMoney;
        this.currentBet = currentBet;
        this.gameStatus = gameStatus;
    }

    public void placeBet(int amount) {
        if (amount <= playerMoney && amount > 0) {
            currentBet = amount;
            playerMoney -= amount;

        }
    }

    public void startNewRound() {
        playerHand.clear();
        dealerHand.clear();

        // Deal cards
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        if (playerHand.isBlackJack()) {
            if (dealerHand.isBlackJack()) {
                playerMoney += currentBet; // Push - return bet
                gameStatus = GameStatus.BOTH_BLACKJACK;
                currentBet = 0;
            } else {
                playerMoney += (currentBet * 2.5); // Blackjack pays 3:2
                gameStatus = GameStatus.PLAYER_BLACKJACK;
                currentBet = 0;
            }
        } else if (dealerHand.isBlackJack()) {
            gameStatus = GameStatus.DEALER_BLACKJACK;
            currentBet = 0;
        } else {
            gameStatus = GameStatus.PLAYER_TURN;
        }
    }

    public void playerHit() {
        if (gameStatus == GameStatus.PLAYER_TURN) {
            playerHand.addCard(deck.drawCard());
            if (playerHand.isBusted()) {
                gameStatus = GameStatus.PLAYER_BUST;
                currentBet = 0;
            }
        }
    }

    public void determineWinner() {
        int playerValue = playerHand.calculateValue();
        int dealerValue = dealerHand.calculateValue();

        if (dealerHand.isBusted()) {
            gameStatus = GameStatus.DEALER_BUST;
            playerMoney += currentBet * 2; // Win pays back betting money and win money
        } else if (playerValue > dealerValue) {
            gameStatus = GameStatus.PLAYER_WIN;
            playerMoney += currentBet * 2;
        } else if (dealerValue > playerValue) {
            gameStatus = GameStatus.DEALER_WIN;
        } else {
            gameStatus = GameStatus.PUSH;
            playerMoney += currentBet; // Push will pays back betting money
        }

        currentBet = 0;
    }

    public void dealerPlay() {
        // Dealer must hit until 17 or higher
        while (dealerHand.calculateValue() < 17) {
            dealerHand.addCard(deck.drawCard());
        }

        determineWinner();
    }

    public void playerStand() {
        if (gameStatus == GameStatus.PLAYER_TURN) {
            gameStatus = GameStatus.DEALER_TURN;
        }

        determineWinner();
    }
}
