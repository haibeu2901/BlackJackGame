/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beu29
 */
public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public boolean isBlackJack() {
        return (cards.size() == 2 && calculateValue() == 21);
    }

    public boolean isBusted() {
        return (calculateValue() > 21);
    }
}
