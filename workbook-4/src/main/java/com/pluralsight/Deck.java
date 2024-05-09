package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        // Create and add cards to the ArrayList
        for (String suit : suits){
            for (String value : values){
                Card card = new Card(suit, value);
                cards.add(card);
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        // Deal the card at the top of the deck if there is one
        if (cards.size() > 0) {
            Card card = cards.remove(0);
            return card;
        } else {
            return null;
        }
    }

    // Return the size of the deck
    public int getSize() {
        return cards.size();
    }
}
