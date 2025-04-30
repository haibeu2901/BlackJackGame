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
    
    public void startNewRound() {
        playerHand
    }
    
    public void placeBet(int amount) {
        if (amount<=playerMoney && amount>0) {
            currentBet = amount;
            playerMoney-=amount;
            
        }
    }
    
    

}
