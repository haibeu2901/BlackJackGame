/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author beu29
 */
public class Card {

    private String suit;
    private String rank;
    private int value;

    public Card() {
    }

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public String getSymbol() {
        switch (suit) {
            case "Spades":
                return "♠";
            case "Clubs":
                return "♣";
            case "Diamonds":
                return "♦";
            case "Hearts":
                return "♥";
            default:
                return "";
        }
    }

    public boolean isRed() {
        return (suit.equals("Diamonds") || suit.equals("Hearts"));
    }

}
