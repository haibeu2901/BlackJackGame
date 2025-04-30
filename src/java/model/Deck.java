/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author beu29
 */
public class Deck {

    private List<Card> cards;

    private void initialize() {
        String suits[] = {"Spades", "Clubs", "Diamonds", "Hearts"};
        String ranks[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int values[] = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Deck() {
        cards = new ArrayList<>();
        initialize();
        shuffle();
    }
    
    public Card drawCard() {
        if (cards.isEmpty()) {
            initialize();
            shuffle();
        }
        return cards.remove(0);
    }

}
